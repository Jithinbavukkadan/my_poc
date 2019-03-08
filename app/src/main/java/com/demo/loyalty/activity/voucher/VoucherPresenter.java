package com.demo.loyalty.activity.voucher;

import com.demo.data.events.VouchersFailureEvent;
import com.demo.data.events.VouchersSuccessEvent;
import com.demo.data.repo.PreferenceRepo;
import com.demo.loyalty.modules.EventBusModule;
import com.demo.loyalty.modules.PreferenceRepositoryModule;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class VoucherPresenter implements VouchersMvpContract.Presenter {
    private VouchersMvpContract.View view;
    private VouchersMvpContract.Model model;
    private EventBus mEventBus;
    private PreferenceRepo mPreferenceRepo;

    private VoucherPresenter(VouchersMvpContract.View view, VouchersMvpContract.Model model, EventBus eventBus,
            PreferenceRepo preferenceRepo) {
        this.view = view;
        this.model = model;
        mEventBus = eventBus;
        mPreferenceRepo = preferenceRepo;
    }

    public VoucherPresenter(VouchersMvpContract.View view) {
        this(view, new VoucherModel(), EventBusModule.eventBus(), PreferenceRepositoryModule.preferenceRepo());
    }

    @Override
    public void redeemToVoucher() {
        view.showLoading();
        model.redeemToVoucher(mPreferenceRepo.getEmployeeId());
    }

    @Subscribe
    @Override
    public void onVoucherSuccess(VouchersSuccessEvent event) {
        view.hideLoading();
        mPreferenceRepo.setTotalPoints(Integer.parseInt(event.getEntity().getPoints()));
        mPreferenceRepo.setRedeemToVouchers(true);
        view.loadVoucherInfo();
    }

    @Subscribe
    @Override
    public void onVoucherFailure(VouchersFailureEvent event) {
        view.showError(event.getApiError());
        view.hideLoading();
    }

    @Override
    public void register() {
        mEventBus.register(this);
    }

    @Override
    public void unregister() {
        mEventBus.unregister(this);
    }

}
