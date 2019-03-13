package com.demo.loyalty.activity.landing;

import com.demo.data.model.server.TransactionSingleEntity;
import com.demo.loyalty.R;
import com.demo.loyalty.view.CollectOrRedeemPointsView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TransactionAdapter extends BaseAdapter {

    private final LayoutInflater mLayoutInflater;
    private List<TransactionSingleEntity> mTransactions;

    public TransactionAdapter(Context context, List<TransactionSingleEntity> transactions) {
        mTransactions = transactions;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public List<TransactionSingleEntity> getTransactions() {
        return mTransactions;
    }

    public void setTransactions(List<TransactionSingleEntity> transactions) {
        mTransactions = transactions;
    }

    @Override
    public int getCount() {
        return mTransactions.size();
    }

    @Override
    public Object getItem(int position) {
        return mTransactions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View newView;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
            newView = convertView;
        } else {
            newView = mLayoutInflater.inflate(R.layout.transaction_item_view, parent, false);
            holder = new ViewHolder(newView);
            newView.setTag(holder);
        }

        TransactionSingleEntity entity = mTransactions.get(position);
        String displayText = entity.toString();
        holder.mTransactionDetails.setText(displayText);

        if (entity.getTranstype().equalsIgnoreCase(TransactionSingleEntity.COLLECT)) {
            holder.mTransactionIndicator.setBackground(parent.getContext().getDrawable(R.drawable.transaction_collect_indicator));
        } else {
            holder.mTransactionIndicator.setBackground(parent.getContext().getDrawable(R.drawable.transaction_redeem_indicator));
        }
        return newView;
    }

    static class ViewHolder {
        @BindView(R.id.transaction_details)
        TextView mTransactionDetails;

        @BindView(R.id.transaction_indicator)
        View mTransactionIndicator;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
