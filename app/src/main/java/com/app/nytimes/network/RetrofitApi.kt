package com.app.nytimes.network

import com.app.nytimes.BuildConfig
import com.app.nytimes.models.MostViewedArticlesData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitApi {

    @GET("viewed/{profileNum}.json?api-key=${BuildConfig.NY_TIMES_API_KEY}")
    fun getDataFromApi(@Path("profileNum") profileNum: Int): Call<MostViewedArticlesData>

}