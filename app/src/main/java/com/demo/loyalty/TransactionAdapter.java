package com.demo.loyalty;

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
    private List<String> mTransactions;

    public TransactionAdapter(Context context, List<String> transactions) {
        mTransactions = transactions;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public List<String> getTransactions() {
        return mTransactions;
    }

    public void setTransactions(List<String> transactions) {
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
        String details = mTransactions.get(position);
        holder.mTransactionDetails.setText(details);
        return newView;
    }

    static class ViewHolder {
        @BindView(R.id.transaction_details)
        TextView mTransactionDetails;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }
}
