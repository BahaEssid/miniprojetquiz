package com.bahaessid.quizapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ThemeAdapter extends RecyclerView.Adapter<ThemeAdapter.ThemeViewHolder> {

    private List<String> themes;
    private OnItemClickListener onItemClickListener;

    public ThemeAdapter(List<String> themes, OnItemClickListener onItemClickListener) {
        this.themes = themes;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ThemeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ThemeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThemeViewHolder holder, int position) {
        final String theme = themes.get(position);
        holder.textViewTheme.setText(theme);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(theme);
            }
        });
    }

    @Override
    public int getItemCount() {
        return themes.size();
    }

    public interface OnItemClickListener {
        void onItemClick(String themeSelectionne);
    }

    static class ThemeViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTheme;

        ThemeViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTheme = itemView.findViewById(android.R.id.text1);
        }
    }
}