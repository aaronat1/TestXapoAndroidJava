package com.aaronat1.desarrollo.githubtrending.main.events;

import com.aaronat1.desarrollo.githubtrending.entities.Response;

public class MainEvent {

    public static final int ON_GET_TRENDING_REPOSITORIES_ERROR   = 0;
    public static final int ON_GET_TRENDING_REPOSITORIES_SUCCESS = 1;

    private int eventType;

    private Response response;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
