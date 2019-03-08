package com.demo.loyalty.activity.voucher;

import com.demo.data.api.ApiError;
import com.demo.data.model.server.TransactionSingleEntity;
import com.demo.data.repo.PreferenceRepo;
import com.demo.loyalty.CustomFontActivity;
import com.demo.loyalty.R;
import com.demo.loyalty.activity.landing.LandingActivity;
import com.demo.loyalty.modules.PreferenceRepositoryModule;
import com.github.ksoichiro.android.observablescrollview.ObservableListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class VoucherActivity extends CustomFontActivity implements VouchersMvpContract.View, Toolbar.OnMenuItemClickListener {
    private PreferenceRepo mRepo;
    private List<VoucherEntity> mEntities;
    private VouchersMvpContract.Presenter mPresenter;
    private VoucherAdapter mAdapter;


    @BindView(R.id.progress_bar)
    View mProgressView;

    @BindView(R.id.no_voucher)
    View mNoVoucher;

    @BindView(R.id.voucher_list)
    RecyclerView mRecyclerView;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    public VoucherActivity() {
        this(PreferenceRepositoryModule.preferenceRepo());
    }

    public VoucherActivity(PreferenceRepo repo) {
        mRepo = repo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voucher);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToLandingScreen();
            }
        });

        mToolbar.setOnMenuItemClickListener(this);

        mPresenter = new VoucherPresenter(this);

        loadVoucherInfo();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.voucher_menu, menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.redeem_voucher) {
            startRedeemToVoucher(new ConfirmationListener() {
                @Override
                public void confirm() {
                    mPresenter.redeemToVoucher();
                }
            });
        }
        return false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.register();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.unregister();
    }

    @Override
    public void showError(ApiError error) {
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        mProgressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressView.setVisibility(View.GONE);
    }

    @Override
    public void showNoVoucher() {
        mRecyclerView.setVisibility(View.GONE);
        mNoVoucher.setVisibility(View.VISIBLE);
    }

    @Override
    public void navigateToLandingScreen() {
        startActivity(new Intent(this, LandingActivity.class));
        finish();
    }

    @Override
    public void startRedeemToVoucher(ConfirmationListener listener) {
        CharSequence title = "Redeem to vouchers";
        CharSequence buttonTxt = "Redeem";
        CharSequence message = "Do you want to redeem " + mRepo.getTotalPoints() + " points to 2 vouchers ";

        AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle(title)
                .setMessage(message)
                .setPositiveButton(buttonTxt, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.confirm();
                    }
                })
                .create();
        alertDialog.show();
    }

    @Override
    public void loadVoucherInfo() {
        mNoVoucher.setVisibility(View.GONE);
        if (mRepo.isRedeemedToVouchers()) {
            mEntities = VoucherEntity.getVouchersData();
            mRecyclerView.setVisibility(View.VISIBLE);
            mAdapter = new VoucherAdapter(mEntities);
            mAdapter.notifyDataSetChanged();
        } else {
            showNoVoucher();
        }
    }

    interface ConfirmationListener {
        void confirm();
    }

}
