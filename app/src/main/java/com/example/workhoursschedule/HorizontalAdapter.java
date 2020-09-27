package com.example.workhoursschedule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.ViewHolder> {
    ArrayList<HorizontalModel> horizontal_layout_models;
    Context context;


    public HorizontalAdapter(Context context, ArrayList<HorizontalModel> horizontalModels) {
        this.context = context;
        this.horizontal_layout_models = horizontalModels;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create View
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.month_horizontal_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(horizontal_layout_models.get(position).getMonthNames());
    }

    @Override
    public int getItemCount() {
        return horizontal_layout_models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Variable init
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Assign variable
            textView = itemView.findViewById(R.id.text_view);
        }
    }
}
