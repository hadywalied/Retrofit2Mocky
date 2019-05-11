package com.test.androidretrofit2example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("v2/5cd69ba0300000640060617b")
    public Call<List<ApiObject>> getAllPost();

}
