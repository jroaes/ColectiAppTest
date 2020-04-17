package com.jroaes.colectiapptest.requests;

import androidx.annotation.NonNull;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.jroaes.colectiapptest.dto.DataResponse;
import com.jroaes.colectiapptest.network.ApiUtils;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by ARTEM PROKHOROV on 19.10.2018.
 */
public class DataMarkers {

    private static DataMarkers instance;
    public DataMarkersCallback listener = null;
    public boolean state = false;
    public String error;

    public static DataMarkers getInstance() {
        if (instance == null) instance = new DataMarkers();
        return instance;
    }


    public interface DataMarkersCallback {
        void onRequestFinished(boolean state, String error, ArrayList<DataResponse> dataMarkersList);
    }


    public void reqState(DataMarkersCallback EmailValidCallback) {

        this.listener = EmailValidCallback;
        Call<ArrayList<DataResponse>> call = ApiUtils.getServices().getData();
        call.enqueue(new Callback<ArrayList<DataResponse>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<DataResponse>> call, @NonNull retrofit2.Response<ArrayList<DataResponse>> response) {
                try {
                    state = true;
                    error = "ok";
                    DataMarkers.this.listener.onRequestFinished(state,error, response.body());

                } catch (Exception e) {
                    e.printStackTrace();
                    state = false;
                    error = "error";
                    DataMarkers.this.listener.onRequestFinished(state, error, null);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<DataResponse>> call, @NonNull Throwable t) {
                error = "error";
                state = false;
                DataMarkers.this.listener.onRequestFinished(state, error, null);
            }
        });
    }
}
