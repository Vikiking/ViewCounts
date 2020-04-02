package com.example.viewcounts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.main_rv);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(new CountAdapter(getSampleList()));
    }

    private List<Count> getSampleList() {
        List<Count> counts = new ArrayList<>();
        counts.add(new Count(Currency.getInstance("EUR"), 200.50));
        counts.add(new Count(Currency.getInstance("RUR"), 100000.00));
        counts.add(new Count(Currency.getInstance("USD"), 300.00));
        counts.add(new Count(Currency.getInstance("RUR"), 500.30));
        counts.add(new Count(Currency.getInstance("USD"), 20000.00));

        Collections.sort(counts);

        return counts;
    }

}
