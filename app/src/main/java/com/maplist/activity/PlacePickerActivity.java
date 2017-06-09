package com.maplist.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.maplist.R;
import com.maplist.model.PlaceResponse;
import com.maplist.network.ApiClient;
import com.maplist.network.ApiInterface;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlacePickerActivity extends AppCompatActivity {

    private static final int PLACE_PICKER_REQUEST = 1000;
    private GoogleApiClient mClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .build();
        placePickerWidget();
    }

    private void placePickerWidget() {

        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
        try {
            startActivityForResult(builder.build(PlacePickerActivity.this), PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
                build_retrofit_and_get_response(place.getLatLng().latitude, place.getLatLng().longitude);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mClient.connect();
    }
    @Override
    protected void onStop() {
        mClient.disconnect();
        super.onStop();
    }


    private void build_retrofit_and_get_response(Double latitude, Double longitude) {

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<PlaceResponse> call = apiService.getNearbyPlaces("restaurant", latitude + "," + longitude, 1000);
        call.enqueue(new Callback<PlaceResponse>() {
            @Override
            public void onResponse(Call<PlaceResponse> call, Response<PlaceResponse> response) {

                if (response.isSuccessful()) {

                    ArrayList<String> nameList = new ArrayList<String>();
                    try {
                        for (int i = 0; i < response.body().getResults().size(); i++) {
                            nameList.add(response.body().getResults().get(i).getName());
                        }
                    } catch (Exception e) {
                        Log.d("onResponse", "There is an error");
                        e.printStackTrace();
                    }
                    if(nameList != null) {

                        Intent intent = new Intent(PlacePickerActivity.this, MapDataActivity.class);
                        intent.putStringArrayListExtra("list", nameList);
                        startActivity(intent);
                    }
                }
            }

            @Override
            public void onFailure(Call<PlaceResponse> call, Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
    }
}
