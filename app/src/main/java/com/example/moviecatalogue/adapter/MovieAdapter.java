package com.example.moviecatalogue.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviecatalogue.model.Movie;
import com.example.moviecatalogue.R;
import com.example.moviecatalogue.view.ClickItemListener;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<Movie> movies;
    private final ClickItemListener listener;

    public MovieAdapter(Context context, ClickItemListener listener) {
        this.context = context;
        this.listener = listener;
        this.movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        final Movie movie = (Movie) getItem(position);
        viewHolder.bind(movie);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickItem(movie);
            }
        });
        return view;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    private class ViewHolder {
        private final TextView txtTitle;
        private final TextView txtDate;
        private final ImageView ivPoster;
        ViewHolder(View view) {
            txtTitle = view.findViewById(R.id.tvTitle);
            txtDate = view.findViewById(R.id.tvDate);
            ivPoster = view.findViewById(R.id.ivPoster);
        }
        void bind(Movie movie) {
            txtTitle.setText(movie.getTitle());
            txtDate.setText(movie.getDate());
            Glide.with(context).load(movie.getPoster()).into(ivPoster);
        }
    }
}
