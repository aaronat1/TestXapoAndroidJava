package com.aaronat1.desarrollo.githubtrending.entities;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class TrendingRepository implements Serializable {

    private long id;

    private String name;

    private String full_name;

    private Owner owner;

    private String html_url;

    private String description;

    private String language;

    private License license;

    private String[] topics;

    private long forks;

    private long open_issues;

    private long watchers;

    private String default_branch;

    private float score;

    private String created_at;

    private String updated_at;

    private String pushed_at;


}
