package com.example.viewcounts;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderEUR extends RecyclerView.ViewHolder {

    private TextView tvCode, tvName;

    public ViewHolderEUR(@NonNull View itemView) {
        super(itemView);
        tvCode = (TextView) itemView.findViewById(R.id.eur_tv_code);
        tvName = (TextView) itemView.findViewById(R.id.eur_tv_name);
    }

    public void setValues(String code, String name) {
        tvCode.setText(code);
        tvName.setText(name);
    }

}
