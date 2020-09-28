package com.example.workhoursschedule;

import android.os.Bundle;


import androidx.appcompat.widget.Toolbar;

public class SingleMonthActivity extends MainActivity implements HorizontalAdapter.OnMonthClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        months_recycler_view = findViewById(R.id.horizontal_view);
        days_recycler_view = findViewById(R.id.vertical_view);

        getAllMonths();
        getMonthAllDays();
        setHorizontalLayout();
        setVerticalLayout();
    }

    @Override
    public void on_month_click_to_new_activity(int position) {
        super.on_month_click_to_new_activity(position);
    }
}
