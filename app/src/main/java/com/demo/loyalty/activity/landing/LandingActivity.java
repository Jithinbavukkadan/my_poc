package com.demo.loyalty.activity.landing;

import com.google.android.material.navigation.NavigationView;
import com.google.zxing.integration.android.IntentIntegrator;

import com.demo.data.api.ApiError;
import com.demo.data.model.server.UserDetails;
import com.demo.data.model.server.TransactionSingleEntity;
import com.demo.loyalty.BarcodeCaptureActivity;
import com.demo.loyalty.CustomFontActivity;
import com.demo.loyalty.R;
import com.demo.loyalty.TransactionAdapter;
import com.demo.loyalty.view.HeaderView;
import com.github.ksoichiro.android.observablescrollview.ObservableListView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.ActionBarDrawerToggle;
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

    @BindView(R.id.landing_listview)
    ObservableListView mTransactionsList;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        initializeNavigationDrawer();
        initializeView();

        mPresenter.loadUserInfo();
        mPresenter.loadTransactions();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
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
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
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
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

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
}
