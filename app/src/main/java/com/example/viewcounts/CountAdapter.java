package com.example.viewcounts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

public class CountAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Count> items;
    private final int RUR = 0, USD = 1, EUR = 2;

    public CountAdapter(List<Count> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        int codeCurrency = -1;
        try {
            if (items.get(position).currency.equals(Currency.getInstance("RUR"))) {
                codeCurrency = RUR;
            } else if (items.get(position).currency.equals(Currency.getInstance("USD"))) {
                codeCurrency = USD;
            } else if (items.get(position).currency.equals(Currency.getInstance("EUR"))) {
                codeCurrency = EUR;
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return codeCurrency;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case RUR:
                View viewRUR = inflater.inflate(R.layout.rur_item, parent, false);
                viewHolder = new ViewHolderRUR(viewRUR);
                break;
            case USD:
                View viewUSD = inflater.inflate(R.layout.usd_item, parent, false);
                viewHolder = new ViewHolderUSD(viewUSD);
                break;
            case EUR:
                View viewEUR = inflater.inflate(R.layout.eur_item, parent, false);
                viewHolder = new ViewHolderEUR(viewEUR);
                break;
            default:
                View viewEmpty = inflater.inflate(R.layout.empty_item, parent, false);
                viewHolder = new ViewHolderEmpty(viewEmpty);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (items.get(position) == null){
            return;
        }

        String amount = String.format("%.2f", items.get(position).amount);
        amount = amount.replace(".", ",");
        String currencyCode = items.get(position).currency.getCurrencyCode();
        String currencyName = items.get(position).currency.getDisplayName();

        switch (holder.getItemViewType()) {
            case RUR:
                ViewHolderRUR vhRUR = (ViewHolderRUR) holder;
                vhRUR.setValues(currencyCode, currencyName, amount);
                break;
            case USD:
                ViewHolderUSD vhUSD = (ViewHolderUSD) holder;
                vhUSD.setValues(currencyCode, currencyName, amount);
                break;
            case EUR:
                ViewHolderEUR vhEUR = (ViewHolderEUR) holder;
                vhEUR.setValues(currencyCode, currencyName);
                break;
        }

    }
}
