package com.demo.loyalty.activity.voucher;

import com.demo.loyalty.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

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
        holder.mVoucherName.setText(voucherEntity.getVoucherTitle() + " - " + voucherEntity.getVoucherCode());
        holder.mVoucherDetails.setText(voucherEntity.getVoucherDetails());
    }

    @Override
    public int getItemCount() {
        return mEntities.size();
    }

    public class VoucherViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.voucher_detail)
        TextView mVoucherDetails;

        @BindView(R.id.voucher_name)
        TextView mVoucherName;

        public VoucherViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
