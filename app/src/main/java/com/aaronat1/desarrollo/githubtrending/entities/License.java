package com.aaronat1.desarrollo.githubtrending.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class License implements Serializable {

    private String key;

    private String name;

    private String spdx_id;


}
