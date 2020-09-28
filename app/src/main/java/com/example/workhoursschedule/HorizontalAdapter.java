package com.example.workhoursschedule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.ViewHolder>{
    ArrayList<HorizontalModel> horizontal_layout_models;
    Context context;
    OnMonthClickListener on_month_click_listener;


    public HorizontalAdapter(Context context, ArrayList<HorizontalModel> horizontal_layout_models, OnMonthClickListener on_month_click_listener) {
        this.context = context;
        this.horizontal_layout_models = horizontal_layout_models;
        this.on_month_click_listener = on_month_click_listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create View
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.month_horizontal_item, parent, false);


        return new ViewHolder(view, on_month_click_listener);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(horizontal_layout_models.get(position).getMonthNames());
//        holder.textView.setOnClickListener(v -> {});
    }


    @Override
    public int getItemCount() {
        return horizontal_layout_models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;
        OnMonthClickListener month_click_listener;
        public ViewHolder(@NonNull View itemView, OnMonthClickListener month_click_listener) {
            super(itemView);
            textView = itemView.findViewById(R.id.certain_month_text_view);
            this.month_click_listener = month_click_listener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            month_click_listener.on_month_click_to_new_activity(getAdapterPosition());
        }
    }

    public interface OnMonthClickListener{
        void on_month_click_to_new_activity(int position);
    }
}
