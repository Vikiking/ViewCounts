package com.example.viewcounts;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderRUR extends RecyclerView.ViewHolder {

    private TextView tvCode, tvName, tvAmount;

    public ViewHolderRUR(@NonNull View itemView) {
        super(itemView);
        tvCode = (TextView) itemView.findViewById(R.id.rur_tv_code);
        tvName = (TextView) itemView.findViewById(R.id.rur_tv_name);
        tvAmount = (TextView) itemView.findViewById(R.id.rur_tv_amount);
    }

    public void setValues(String code, String name, String amount) {
        tvCode.setText(code);
        tvName.setText(name);
        tvAmount.setText(amount);
    }

}
