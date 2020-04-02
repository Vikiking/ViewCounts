package com.example.viewcounts;


import java.util.Currency;

public class Count implements Comparable<Count>{

    public final Currency currency;
    public final double amount;

    public Count(Currency currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    @Override
    public int compareTo(Count o) {
        return getPriority().compareTo(o.getPriority());
    }

    private String getPriority() {
        int priority = 0;
        if (currency.equals(Currency.getInstance("RUR"))) {
            priority = 0;
        } else if (currency.equals(Currency.getInstance("USD"))) {
            priority = 1;
        } else if (currency.equals(Currency.getInstance("EUR"))) {
            priority = 2;
        }
        return String.valueOf(priority);
    }

}
