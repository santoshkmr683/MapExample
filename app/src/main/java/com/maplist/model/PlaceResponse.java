package com.maplist.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by santosh on 8/6/17.
 */

public class PlaceResponse {

    @SerializedName("html_attributions")
    private List<Object> htmlAttributions = null;

    @SerializedName("results")
    private List<Result> results = null;

    @SerializedName("status")
    private String status;

    public List<Object> getHtmlAttributions() {
        return htmlAttributions;
    }

    public void setHtmlAttributions(List<Object> htmlAttributions) {
        this.htmlAttributions = htmlAttributions;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
