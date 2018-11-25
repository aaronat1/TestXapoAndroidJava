package com.aaronat1.desarrollo.githubtrending.main;

import com.aaronat1.desarrollo.githubtrending.main.events.MainEvent;
import com.aaronat1.desarrollo.githubtrending.main.ui.MainView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;

    private EventBus eventBus;

    private MainInteractor mainInteractor;

    public MainPresenterImpl(MainView mainView, MainInteractor mainInteractor) {
        this.mainView = mainView;
        this.eventBus = EventBus.getDefault();
        this.mainInteractor = mainInteractor;
    }

    @Override
    public void onStart() {
        eventBus.register(this);
    }

    @Override
    public void onStop() {
        eventBus.unregister(this);
    }

    @Override
    public void getTrendingRepositories() {
        mainView.showLoadingView();
        mainInteractor.getTrendingRepositories();
    }

    @Subscribe
    @Override
    public void onEventMainThread(MainEvent mainEvent) {
        mainView.hideLoadingView();
        switch (mainEvent.getEventType()) {
            case MainEvent.ON_GET_TRENDING_REPOSITORIES_ERROR:
                mainView.showErrorView();
                break;
            case MainEvent.ON_GET_TRENDING_REPOSITORIES_SUCCESS:
                mainView.showTrendingRepositories(mainEvent.getResponse().getItems());

        }
    }
}
