package com.aaronat1.desarrollo.githubtrending.main;

import com.aaronat1.desarrollo.githubtrending.main.events.MainEvent;

public interface MainPresenter {

    void onStart();

    void onStop();

    void getTrendingRepositories();

    void onEventMainThread(MainEvent mainEvent);

}
