package com.example.moviecatalogue.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.moviecatalogue.DetailActivity;
import com.example.moviecatalogue.R;
import com.example.moviecatalogue.adapter.MainAdapter;
import com.example.moviecatalogue.model.Catalog;
import com.example.moviecatalogue.presenter.MainPresenter;
import com.example.moviecatalogue.view.ClickItemListener;
import com.example.moviecatalogue.view.MainView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment implements MainView, ClickItemListener {


    @BindView(R.id.rvMovie)
    RecyclerView rvMovie;

    private MainAdapter adapter;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new MainAdapter(getActivity(), this);
        MainPresenter presenter = new MainPresenter(getActivity(), this);
        presenter.setDataMovie();
        rvMovie.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvMovie.setHasFixedSize(true);
        rvMovie.setAdapter(adapter);
    }

    @Override
    public void onClickItem(Catalog catalog) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_CATALOG, catalog);
        startActivity(intent);
    }

    @Override
    public void showList(ArrayList<Catalog> catalogs) {
        adapter.setCatalogs(catalogs);
    }
}
