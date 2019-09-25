package com.example.javakotlin.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/";
    private static Retrofit retrofit;

    public static RemoteServices getInstance(){
        if(retrofit == null){
            Gson gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
        }
        return retrofit.create(RemoteServices.class);
    }
}
