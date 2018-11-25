package com.aaronat1.desarrollo.githubtrending.api;

import com.aaronat1.desarrollo.githubtrending.BaseTest;
import com.aaronat1.desarrollo.githubtrending.BuildConfig;
import com.aaronat1.desarrollo.githubtrending.entities.Response;
import com.aaronat1.desarrollo.githubtrending.entities.TrendingRepository;
import com.aaronat1.desarrollo.githubtrending.io.ApiClient;
import com.aaronat1.desarrollo.githubtrending.io.GithubTrendingAPI;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import org.robolectric.RobolectricTestRunner;

import retrofit2.Call;

@RunWith(RobolectricTestRunner.class)
//@Config(constants = BuildConfig.class, sdk = 28)
public class RepositoryServiceTest extends BaseTest{
    private GithubTrendingAPI service;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        service = ApiClient.getInstance().getClient().create(GithubTrendingAPI.class);
    }

    @Test
    public void doGetTrendingRepositories() throws Exception {

        Call<Response> call = service.getTrendingRepositories();
        retrofit2.Response<Response> response = call.execute();
        assertTrue(response.isSuccessful());

        Response response1 = response.body();
        assertEquals(43754, response1.getTotal_count());

        TrendingRepository trendingRepository = response1.getItems().get(0);
        assertNotNull(trendingRepository);

    }

}
