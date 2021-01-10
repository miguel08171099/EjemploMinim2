package com.example.minimo2practica;

import com.example.minimo2practica.models.Museums;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {
    @GET("/api/dataset/museus/format/json/")
    Call<Museums> getMuseums();
}
