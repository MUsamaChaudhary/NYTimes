package com.app.nytimes.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    ////viewed/1.json?api-key=
    private const val BASE_URL = "https://api.nytimes.com/svc/mostpopular/v2/"

    private val retrofitClient = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}