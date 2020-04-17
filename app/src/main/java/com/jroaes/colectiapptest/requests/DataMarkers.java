package com.jroaes.colectiapptest.requests;

import androidx.annotation.NonNull;

import com.jroaes.colectiapptest.dto.DataResponse;
import com.jroaes.colectiapptest.network.ApiUtils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

import static com.jroaes.colectiapptest.Constants.NO_INTERNET_ERROR;

/**
 * Created by JORGE ROA on 17.04.2020.
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
                    DataMarkers.this.listener.onRequestFinished(state, error, response.body());

                } catch (Exception e) {
                    e.printStackTrace();
                    state = false;
                    DataMarkers.this.listener.onRequestFinished(state, error, null);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<DataResponse>> call, @NonNull Throwable t) {
                error = NO_INTERNET_ERROR;
                state = false;
                DataMarkers.this.listener.onRequestFinished(state, error, null);
            }
        });
    }
}
