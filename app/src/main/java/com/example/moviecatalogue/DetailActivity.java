package com.example.moviecatalogue;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.moviecatalogue.model.Catalog;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_CATALOG = "extra_catalog";

    @BindView(R.id.ivPoster)
    ImageView ivPoster;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvDate)
    TextView tvDate;
    @BindView(R.id.tvDescription)
    TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        Catalog catalog = getIntent().getParcelableExtra(EXTRA_CATALOG);
        if (catalog != null) {
            tvTitle.setText(catalog.getTitle());
            tvDate.setText(catalog.getDate());
            tvDescription.setText(catalog.getDesc());
            Glide.with(this).load(catalog.getPoster()).into(ivPoster);
            getSupportActionBar().setTitle(catalog.getTitle());
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
