package com.app.nytimes.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.app.nytimes.models.MostViewedArticle
import com.app.nytimes.models.MostViewedArticlesData
import com.app.nytimes.network.RetrofitApi
import com.app.nytimes.network.RetrofitService
import retrofit2.Call
import retrofit2.Response

object RetrofitRepository {
    private val TAG = RetrofitRepository::class.simpleName

    private val retrofitApi = RetrofitService.createService(RetrofitApi::class.java)

    fun getArticles(
        profileNum: Int,
        articlesResponseNew: MutableLiveData<List<MostViewedArticle>?>?,
        isLoading: MutableLiveData<Boolean>
    ) {
        isLoading.value = true
        retrofitApi.getDataFromApi(profileNum)
            .enqueue(object : retrofit2.Callback<MostViewedArticlesData> {
                override fun onResponse(
                    call: Call<MostViewedArticlesData>,
                    response: Response<MostViewedArticlesData>,
                ) {
                    isLoading.value = false
                    if (response.isSuccessful && response.body() != null) {
                        response.body()?.items?.let {
                            val list = arrayListOf<MostViewedArticle>()
                            list.addAll(response.body()!!.items!!)
                            articlesResponseNew?.value = it
                            Log.d(TAG, "onResponse: Articles response list size is ${it.size}")
                        } ?: run {
                            Log.d(TAG, "onResponse: Articles response body is null")
                            articlesResponseNew?.value = null
                        }
                    } else {
                        Log.d(TAG, "onResponse: Articles response was unsuccessful")
                        articlesResponseNew?.value = null
                    }
                }

                override fun onFailure(call: Call<MostViewedArticlesData>, t: Throwable) {
                    isLoading.value = false
                    Log.d(TAG, "onFailure: Error in getting articles")
                    articlesResponseNew?.value = null
                }

            })
    }

}