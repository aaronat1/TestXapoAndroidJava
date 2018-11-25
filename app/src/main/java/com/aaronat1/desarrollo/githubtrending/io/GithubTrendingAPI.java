package com.aaronat1.desarrollo.githubtrending.io;

import com.aaronat1.desarrollo.githubtrending.entities.Response;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubTrendingAPI {

    @GET("/search/repositories?q=topic:android")
    Call<Response> getTrendingRepositories();
}

