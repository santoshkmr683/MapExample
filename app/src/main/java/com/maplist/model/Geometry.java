package com.maplist.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by santosh on 8/6/17.
 */

public class Geometry {

    @SerializedName("location")
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
