package com.aaronat1.desarrollo.githubtrending.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class Owner implements Serializable {

    private String login;

    private long id;

    private String avatar_url;


}
