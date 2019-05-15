package com.example.moviecatalogue.presenter;

import android.content.Context;
import android.content.res.TypedArray;

import com.example.moviecatalogue.view.MainView;
import com.example.moviecatalogue.model.Movie;
import com.example.moviecatalogue.R;

import java.util.ArrayList;

public class MainPresenter {

    private final Context context;
    private final MainView mainView;
    private String[] dataTitle;
    private String[] dataDate;
    private TypedArray dataPoster;
    private String[] dataDesc;

    public MainPresenter(Context context, MainView mainView) {
        this.context = context;
        this.mainView = mainView;
    }

    public void setDataMovie() {
        prepare();
        addDataMovie();
    }

    private void prepare() {
        dataTitle = context.getResources().getStringArray(R.array.data_movie);
        dataDate = context.getResources().getStringArray(R.array.data_date);
        dataPoster = context.getResources().obtainTypedArray(R.array.data_poster);
        dataDesc = context.getResources().getStringArray(R.array.data_desc);
    }

    private void addDataMovie() {
        ArrayList<Movie> movies = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            Movie movie = new Movie();
            movie.setPoster(dataPoster.getResourceId(i, -1));
            movie.setTitle(dataTitle[i]);
            movie.setDate(dataDate[i]);
            movie.setDesc(dataDesc[i]);
            movies.add(movie);
        }
        mainView.showList(movies);
    }
}
