package com.example.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.moviecatalogue.adapter.MovieAdapter;
import com.example.moviecatalogue.model.Movie;
import com.example.moviecatalogue.presenter.MainPresenter;
import com.example.moviecatalogue.view.ClickItemListener;
import com.example.moviecatalogue.view.MainView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainView, ClickItemListener {

    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainPresenter presenter = new MainPresenter(this, this);
        adapter = new MovieAdapter(this, this);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        presenter.setDataMovie();
    }

    @Override
    public void showList(ArrayList<Movie> movies) {
        adapter.setMovies(movies);
    }

    @Override
    public void onClickItem(Movie movie) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_MOVIE, movie);
        startActivity(intent);
    }
}
