package com.example.ajay.crownstack.framework;

import com.example.ajay.crownstack.model.Responce;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiInterface {

    @GET("/search?term=Michael+jackson")
    Call<Responce> getSongsList();
}
