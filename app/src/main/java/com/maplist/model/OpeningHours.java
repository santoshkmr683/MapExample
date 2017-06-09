package com.maplist.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by santosh on 8/6/17.
 */

public class OpeningHours {

    @SerializedName("open_now")
    private boolean openNow;

    public boolean isOpenNow() {
        return openNow;
    }

    public void setOpenNow(boolean openNow) {
        this.openNow = openNow;
    }
}
