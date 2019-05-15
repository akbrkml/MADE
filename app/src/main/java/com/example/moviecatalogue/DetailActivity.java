package com.example.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviecatalogue.model.Movie;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        TextView txtTitle = findViewById(R.id.tvTitle);
        TextView txtDate = findViewById(R.id.tvDate);
        TextView txtDesc = findViewById(R.id.tvDescription);
        ImageView ivPoster = findViewById(R.id.ivPoster);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        if (movie != null) {
            txtTitle.setText(movie.getTitle());
            txtDate.setText(movie.getDate());
            txtDesc.setText(movie.getDesc());
            Glide.with(this).load(movie.getPoster()).into(ivPoster);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
