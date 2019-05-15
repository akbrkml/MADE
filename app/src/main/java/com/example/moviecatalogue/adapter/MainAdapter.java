package com.example.moviecatalogue.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviecatalogue.R;
import com.example.moviecatalogue.model.Catalog;
import com.example.moviecatalogue.view.ClickItemListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private final Context context;
    private ArrayList<Catalog> catalogs;
    private final ClickItemListener listener;

    public MainAdapter(Context context, ClickItemListener listener) {
        this.context = context;
        this.listener = listener;
        this.catalogs = new ArrayList<>();
    }

    public void setCatalogs(ArrayList<Catalog> catalogs) {
        this.catalogs = catalogs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(catalogs.get(position));
    }

    @Override
    public int getItemCount() {
        return catalogs.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivPoster)
        ImageView ivPoster;
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvDate)
        TextView tvDate;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(final Catalog catalog) {
            tvTitle.setText(catalog.getTitle());
            tvDate.setText(catalog.getDate());
            Glide.with(context).load(catalog.getPoster()).into(ivPoster);
            itemView.setOnClickListener(v -> listener.onClickItem(catalog));
        }
    }
}
