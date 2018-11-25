package com.aaronat1.desarrollo.githubtrending.main;

import com.aaronat1.desarrollo.githubtrending.io.ApiClient;
import com.aaronat1.desarrollo.githubtrending.io.GithubTrendingAPI;
import com.aaronat1.desarrollo.githubtrending.main.events.MainEvent;

import org.greenrobot.eventbus.EventBus;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepositoryImpl implements MainRepository, Callback<com.aaronat1.desarrollo.githubtrending.entities.Response> {


    @Override
    public void getTrendingRepositories() {
        GithubTrendingAPI githubTrendingAPI = ApiClient.getInstance().getClient().create(GithubTrendingAPI.class);
        Call<com.aaronat1.desarrollo.githubtrending.entities.Response> call = githubTrendingAPI.getTrendingRepositories();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<com.aaronat1.desarrollo.githubtrending.entities.Response> call, Response<com.aaronat1.desarrollo.githubtrending.entities.Response> response) {
        postEvent(MainEvent.ON_GET_TRENDING_REPOSITORIES_SUCCESS, response.body());
    }

    @Override
    public void onFailure(Call<com.aaronat1.desarrollo.githubtrending.entities.Response> call, Throwable t) {
        postEvent(MainEvent.ON_GET_TRENDING_REPOSITORIES_ERROR, null);
    }

    private void postEvent(int type, com.aaronat1.desarrollo.githubtrending.entities.Response response) {
        MainEvent mainEvent = new MainEvent();
        mainEvent.setEventType(type);
        mainEvent.setResponse(response);
        EventBus.getDefault().post(mainEvent);
    }


}
