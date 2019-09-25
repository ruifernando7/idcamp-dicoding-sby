package com.example.javakotlin.data.remote

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/"
    private var retrofit: Retrofit? = null

    val instance: RemoteServices
        get() {
            if (retrofit == null) {
                val gson = GsonBuilder().setLenient().create()
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }
            return retrofit!!.create(RemoteServices::class.java)
        }
}
