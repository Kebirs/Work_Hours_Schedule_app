package com.example.workhoursschedule;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Array;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;


public class MainActivity extends AppCompatActivity implements HorizontalAdapter.OnMonthClickListener {

    // Variable init
    RecyclerView months_recycler_view;
    RecyclerView days_recycler_view;

    // Horizontal view
    ArrayList<HorizontalModel> horizontal_layout_models;
    HorizontalAdapter horizontal_layout_adapter;

    // Vertical view
    ArrayList<VerticalModel> vertical_layout_models;
    VerticalAdapter vertical_layout_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar init and toolbar's data display
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Assign Variable
        months_recycler_view = findViewById(R.id.horizontal_view);
        days_recycler_view = findViewById(R.id.vertical_view);

        getAllMonths();
        getMonthAllDays();
        setHorizontalLayout();
        setVerticalLayout();
    }

    public void setVerticalLayout() {
        // Vertical Layout Design
        LinearLayoutManager v_layout_manager = new LinearLayoutManager(
                MainActivity.this, LinearLayoutManager.VERTICAL, false);
        days_recycler_view.setLayoutManager(v_layout_manager);
        days_recycler_view.setItemAnimator(new DefaultItemAnimator());
        // Vertical Adapter init
        vertical_layout_adapter = new VerticalAdapter(MainActivity.this, vertical_layout_models);
        // Set Vertical Adapter to RecyclerView
        days_recycler_view.setAdapter(vertical_layout_adapter);
    }

    public void setHorizontalLayout() {
        // Horizontal Layout Design
        LinearLayoutManager h_layout_manager = new LinearLayoutManager(
                MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        months_recycler_view.setLayoutManager(h_layout_manager);
        months_recycler_view.setItemAnimator(new DefaultItemAnimator());
        // Horizontal Adapter init
        horizontal_layout_adapter = new HorizontalAdapter(MainActivity.this, horizontal_layout_models, this);
        // Set Horizontal and Vertical Adapter to RecyclerView
        months_recycler_view.setAdapter(horizontal_layout_adapter);
    }

    public void getAllMonths() {
        // Create String format with all months
        String[] months = new DateFormatSymbols().getMonths();
        // Create Integer Array for months
        int size_of_months_in_year = months.length;
        int[] number_of_months = (int[]) Array.newInstance(int.class, size_of_months_in_year);
        // Create List of all months as string
        List<String> monthsList = new ArrayList<String>(Arrays.asList(months));
        // ArrayList of months init
        horizontal_layout_models = new ArrayList<>();
        for (int i = 0; i < months.length; i++) {
            HorizontalModel h_model = new HorizontalModel(number_of_months[i], monthsList.get(i));
            horizontal_layout_models.add(h_model);
        }
    }


    public void getMonthAllDays() {
        // Create list of days in OCTOBER 2020
        Calendar c = new GregorianCalendar(2020, 10, 1);
        SimpleDateFormat m_format = new SimpleDateFormat("EEEE dd MMM", Locale.getDefault());

        int max_month_days = c.getActualMaximum(Calendar.DAY_OF_MONTH);

        ArrayList<String> all_days = new ArrayList<>();

        for (int i = 0; i < max_month_days; i++) {
            all_days.add(m_format.format(c.getTime()));
            c.add(Calendar.DAY_OF_MONTH, 1);
        }

        // Add item position and item name as string to a vertical model
        vertical_layout_models = new ArrayList<>();

        for (int i = 0; i < max_month_days; i++) {
            VerticalModel v_model = new VerticalModel(max_month_days, all_days.get(i));
            vertical_layout_models.add(v_model);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.spinner);

        // Cast spinner dialog to menu
        Spinner spinner = (Spinner) item.getActionView();

        // Create an array of two years, actual and previous
        ArrayList<String> years = new ArrayList<>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = thisYear; i >= thisYear - 1; i--) {
            years.add(Integer.toString(i));
        }
        // Add years to dropdown items adapter
        ArrayAdapter<String> years_adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, years);
        spinner.setAdapter(years_adapter);
        return true;
    }

    @Override
    public void on_month_click_to_new_activity(int position) {

        Intent intent = new Intent(this, SingleMonthActivity.class);
        startActivity(intent);
    }
}