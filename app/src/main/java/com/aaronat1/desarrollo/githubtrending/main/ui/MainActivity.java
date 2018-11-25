package com.aaronat1.desarrollo.githubtrending.main.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.support.v7.widget.LinearLayoutManager;

import com.aaronat1.desarrollo.githubtrending.App;
import com.aaronat1.desarrollo.githubtrending.R;
import com.aaronat1.desarrollo.githubtrending.detail.DetailActivity;
import com.aaronat1.desarrollo.githubtrending.entities.TrendingRepository;
import com.aaronat1.desarrollo.githubtrending.main.MainPresenter;
import com.aaronat1.desarrollo.githubtrending.main.ui.adapters.RepositoriesAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity  implements MainView, RepositoriesAdapter.OnItemClickListener {

    @BindView(R.id.pbLoading)
    ProgressBar pbLoading;

    @BindView(R.id.btnGetRepositories)
    Button btnGetRepositories;

    @BindView(R.id.tvError)
    TextView tvError;

    @BindView(R.id.rvTrendingRepositories)
    RecyclerView rvTrendingRepositories;

    @Inject
    MainPresenter mainPresenter;

    private App app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        app = (App) getApplication();
        setupInjection();
    }

    private void setupInjection() {
        app.getMainComponent(this).inject(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        mainPresenter.onStart();
        mainPresenter.getTrendingRepositories();
    }

    @Override
    public void onStop() {
        super.onStop();
        mainPresenter.onStop();
    }

    @Override
    @OnClick(R.id.btnGetRepositories)
    public void getTrendingRepositories() {
        mainPresenter.getTrendingRepositories();
    }

    @Override
    public void showLoadingView() {
        rvTrendingRepositories.setVisibility(View.GONE);
        tvError.setVisibility(View.GONE);
        btnGetRepositories.setVisibility(View.GONE);
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingView() {
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void showTrendingRepositories(List<TrendingRepository> trendingRepositories) {
        tvError.setVisibility(View.GONE);
        btnGetRepositories.setVisibility(View.GONE);
        RepositoriesAdapter repositoriesAdapter = new RepositoriesAdapter(trendingRepositories, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvTrendingRepositories.setLayoutManager(linearLayoutManager);
        rvTrendingRepositories.setAdapter(repositoriesAdapter);
        rvTrendingRepositories.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErrorView() {
        btnGetRepositories.setVisibility(View.VISIBLE);
        tvError.setVisibility(View.VISIBLE);
        rvTrendingRepositories.setVisibility(View.GONE);
    }

    @Override
    public void showSelectedTrendingRepository(TrendingRepository trendingRepository) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("trendingRepositorySelected", trendingRepository);
        startActivity(intent);
    }


    @Override
    public void onItemClick(TrendingRepository trendingRepository) {
        showSelectedTrendingRepository(trendingRepository);
    }
}
