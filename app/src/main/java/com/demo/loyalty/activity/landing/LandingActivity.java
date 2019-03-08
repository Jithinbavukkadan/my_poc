package com.demo.loyalty.activity.landing;

import com.google.android.material.navigation.NavigationView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import com.demo.data.api.ApiError;
import com.demo.data.model.server.UserDetails;
import com.demo.data.model.server.TransactionSingleEntity;
import com.demo.loyalty.BarcodeCaptureActivity;
import com.demo.loyalty.CustomFontActivity;
import com.demo.loyalty.R;
import com.demo.loyalty.activity.launch.LaunchActivity;
import com.demo.loyalty.activity.voucher.VoucherActivity;
import com.demo.loyalty.view.HeaderView;
import com.github.ksoichiro.android.observablescrollview.ObservableListView;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

public class LandingActivity extends CustomFontActivity
        implements NavigationView.OnNavigationItemSelectedListener, LandingMvpContract.View {
    public static final int REQUEST_CAMERA_PERMISSION = 101;
    private HeaderView mHeaderView;
    private TransactionAdapter mTransactionAdapter;
    private LandingMvpContract.Presenter mPresenter;

    @BindView(R.id.progress_bar)
    View mProgressView;

    @BindView(R.id.landing_listview)
    ObservableListView mTransactionsList;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.nav_view)
    NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        initializeNavigationDrawer();
        initializeView();

        mPresenter = new LandingPresenter(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.register();
        mPresenter.loadUserInfo();
        mPresenter.loadTransactions();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.unregister();
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == REQUEST_CAMERA_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                navigateToCollectOrRedeem();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (scanResult != null
                && scanResult.getContents() != null) {
            String[] bacodeData = mPresenter.processBarcodeData(scanResult.getContents());
            if (bacodeData.length > 1) {
                final String type = bacodeData[0], shopName = bacodeData[1];
                if (type.equalsIgnoreCase(TransactionSingleEntity.REDEEM)
                        && Integer.parseInt(mHeaderView.getUserDetails().getPoints()) < 300) {
                    String message = "You don't have enough points to redeem";
                    showWarningDialog(message);
                } else if (type.equalsIgnoreCase(TransactionSingleEntity.COLLECT) || type
                        .equalsIgnoreCase(TransactionSingleEntity.REDEEM)) {
                    showConfirmationDialog(type, shopName, new ConfirmationListener() {
                        @Override
                        public void confirm() {
                            if (type.equalsIgnoreCase(TransactionSingleEntity.COLLECT)) {
                                mPresenter.collect(shopName);
                            } else {
                                mPresenter.redeem(shopName);
                            }
                        }
                    });
                } else {
                    showError("Invalid barcode");
                }
            }
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION);
            } else {
                navigateToCollectOrRedeem();
            }

        } else if (id == R.id.nav_logout) {
            mPresenter.logout();
        } else if (id == R.id.nav_voucher) {
            navigateToVouchers();
        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void initializeView() {
        mHeaderView = new HeaderView(this);
        mTransactionAdapter = new TransactionAdapter(this, new ArrayList<TransactionSingleEntity>());
        mTransactionsList.setAdapter(mTransactionAdapter);
        mTransactionsList.addHeaderView(mHeaderView, null, false);
    }

    @Override
    public void initializeNavigationDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(this);
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
    public void updateUserDetails(UserDetails entity) {
        mHeaderView.setUserDetails(entity);
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
    public void updateTransactions(List<TransactionSingleEntity> entities) {
        mTransactionAdapter.setTransactions(entities);
        mTransactionAdapter.notifyDataSetChanged();
    }

    @Override
    public void navigateToSettings() {

    }

    @Override
    public void navigateToCollectOrRedeem() {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setCaptureActivity(BarcodeCaptureActivity.class);
        integrator.setOrientationLocked(true);
        integrator.initiateScan();
    }

    @Override
    public void navigateToVouchers() {
        startActivity(new Intent(this, VoucherActivity.class));
        finish();
    }

    @Override
    public void navigateToLaunchScreen() {
        startActivity(new Intent(this, LaunchActivity.class));
        finish();
    }

    @Override
    public void showConfirmationDialog(String type, String shopName, final ConfirmationListener listener) {
        CharSequence title = type.equals(TransactionSingleEntity.COLLECT) ? "Collect" : "Redeem";
        CharSequence collect = "Collect", redeem = "Redeem";
        CharSequence buttonTxt = type.equals(TransactionSingleEntity.COLLECT) ? collect : redeem;
        CharSequence collectMsg = "Do you want to collect 100pts from " + shopName, redeemMsg = "Do you want to redeem 100pts from "
                + shopName;
        CharSequence message = type.equals(TransactionSingleEntity.COLLECT) ? collectMsg : redeemMsg;

        AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle(title)
                .setMessage(message)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
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
    public void showWarningDialog(String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle("iLoyalty")
                .setMessage(message)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        alertDialog.show();
    }

    interface ConfirmationListener {
        void confirm();
    }

}
