package com.jroaes.colectiapptest.network;

import com.jroaes.colectiapptest.Constants;
import com.jroaes.colectiapptest.dto.DataResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;


public interface RetrofitApi {

    @GET(Constants.URL_DATA)
    Call<ArrayList<DataResponse>> getData();

}
