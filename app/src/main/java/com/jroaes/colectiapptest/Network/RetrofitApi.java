package com.jroaes.colectiapptest.Network;

import com.jroaes.colectiapptest.Constants;

import com.jroaes.colectiapptest.dto.DataResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;


public interface RetrofitApi {

    @GET(Constants.URL_DATA)
    Call<DataResponse> getData(@Url String url);

}
