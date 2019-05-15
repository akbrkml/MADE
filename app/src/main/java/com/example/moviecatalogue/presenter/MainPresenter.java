package com.example.moviecatalogue.presenter;

import android.content.Context;
import android.content.res.TypedArray;


import com.example.moviecatalogue.R;
import com.example.moviecatalogue.model.Catalog;
import com.example.moviecatalogue.view.MainView;

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
        prepareMovie();
        addDataMovie();
    }
    public void setDataTv() {
        prepareTv();
        addDataTv();
    }

    private void prepareMovie() {
        dataTitle = context.getResources().getStringArray(R.array.data_movie);
        dataDate = context.getResources().getStringArray(R.array.data_date);
        dataPoster = context.getResources().obtainTypedArray(R.array.data_poster);
        dataDesc = context.getResources().getStringArray(R.array.data_desc);
    }

    private void addDataMovie() {
        ArrayList<Catalog> catalogs = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            Catalog catalog = new Catalog();
            catalog.setPoster(dataPoster.getResourceId(i, -1));
            catalog.setTitle(dataTitle[i]);
            catalog.setDate(dataDate[i]);
            catalog.setDesc(dataDesc[i]);
            catalogs.add(catalog);
        }
        mainView.showList(catalogs);
    }

    private void prepareTv() {
        dataTitle = context.getResources().getStringArray(R.array.data_movie_tv);
        dataDate = context.getResources().getStringArray(R.array.data_date_tv);
        dataPoster = context.getResources().obtainTypedArray(R.array.data_poster_tv);
        dataDesc = context.getResources().getStringArray(R.array.data_desc_tv);
    }

    private void addDataTv() {
        ArrayList<Catalog> catalogs = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            Catalog catalog = new Catalog();
            catalog.setPoster(dataPoster.getResourceId(i, -1));
            catalog.setTitle(dataTitle[i]);
            catalog.setDate(dataDate[i]);
            catalog.setDesc(dataDesc[i]);
            catalogs.add(catalog);
        }
        mainView.showList(catalogs);
    }
}
