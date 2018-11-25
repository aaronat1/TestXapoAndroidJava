package com.aaronat1.desarrollo.githubtrending.entities;

import java.util.List;

import lombok.Data;

@Data
public class Response {

    private int total_count;

    private boolean incomplete_results;

    private List<TrendingRepository> items;
}
