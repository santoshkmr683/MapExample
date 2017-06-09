package com.maplist.network;

import com.maplist.model.PlaceResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by santosh on 8/6/17.
 */

public interface ApiInterface {

    /*
     * Retrofit get annotation with our URL
     * And our method that will return us details of near place.
     */
    @GET("api/place/nearbysearch/json?sensor=true&key=AIzaSyDN7RJFmImYAca96elyZlE5s_fhX-MMuhk")
    Call<PlaceResponse> getNearbyPlaces(@Query("type") String type, @Query("location") String location, @Query("radius") int radius);

}
