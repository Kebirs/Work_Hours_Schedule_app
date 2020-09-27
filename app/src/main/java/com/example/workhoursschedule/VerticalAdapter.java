package com.example.workhoursschedule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.ViewHolder>  {
    ArrayList<VerticalModel> vertical_layout_models;
    Context context;

    public VerticalAdapter(Context context, ArrayList<VerticalModel> vertical_models) {
        this.context = context;
        this.vertical_layout_models = vertical_models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create View
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.day_vertical_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView1.setText((CharSequence) vertical_layout_models.get(position).getDaysNames());
    }

    @Override
    public int getItemCount() {
        return vertical_layout_models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Variable init
        TextView textView1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Assign variable
            textView1 = itemView.findViewById(R.id.text_view_1);
        }
    }
}
