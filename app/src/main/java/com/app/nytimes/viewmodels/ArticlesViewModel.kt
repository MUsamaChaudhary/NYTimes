package com.app.nytimes.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.nytimes.models.MostViewedArticle
import com.app.nytimes.repositories.RetrofitRepository

class ArticlesViewModel : ViewModel() {
    private var articlesResponseNew: MutableLiveData<List<MostViewedArticle>?>? = null
    private var isLoading = MutableLiveData<Boolean>(false);
    private var isSwipeLoading = MutableLiveData<Boolean>(false);

    fun init(profileNum: Int) {
        if (articlesResponseNew != null) {
            return
        }
        articlesResponseNew = MutableLiveData()
        RetrofitRepository.getArticles(profileNum, articlesResponseNew, isLoading, null )
    }

    fun getLiveArticles(): LiveData<List<MostViewedArticle>?>? {
        return articlesResponseNew
    }

    // call this fun in case of swipe refresh
    fun loadArticles(profileNum: Int) {
        RetrofitRepository.getArticles(profileNum, articlesResponseNew, null, isSwipeLoading)
    }

    fun listenLoading(): LiveData<Boolean> = isLoading

    fun listenSwipeLoading(): LiveData<Boolean> = isSwipeLoading

}