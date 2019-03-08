package com.demo.loyalty.activity.voucher;

import com.demo.loyalty.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VoucherAdapter extends RecyclerView.Adapter<VoucherAdapter.VoucherViewHolder> {
    private List<VoucherEntity> mEntities;

    public VoucherAdapter(List<VoucherEntity> entities) {
        mEntities = entities;
    }

    public List<VoucherEntity> getEntities() {
        return mEntities;
    }

    public void setEntities(List<VoucherEntity> entities) {
        mEntities = entities;
    }

    @NonNull
    @Override
    public VoucherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vouchers_item_view, parent, false);
        return new VoucherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VoucherViewHolder holder, int position) {
        VoucherEntity voucherEntity = mEntities.get(position);
    }

    @Override
    public int getItemCount() {
        return mEntities.size();
    }

    public class VoucherViewHolder extends RecyclerView.ViewHolder {
        public VoucherViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
