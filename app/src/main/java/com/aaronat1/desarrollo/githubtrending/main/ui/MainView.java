package com.aaronat1.desarrollo.githubtrending.main.ui;

import com.aaronat1.desarrollo.githubtrending.entities.TrendingRepository;

import java.util.List;

public interface MainView {

    void getTrendingRepositories();

    void showLoadingView();

    void hideLoadingView();

    void showTrendingRepositories(List<TrendingRepository> trendingRepositories);

    void showErrorView();

    void showSelectedTrendingRepository(TrendingRepository trendingRepository);
}
