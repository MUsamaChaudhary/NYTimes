package com.app.nytimes

import android.os.Bundle
import androidx.activity.viewModels
import androidx.viewbinding.ViewBinding
import com.app.nytimes.base.BaseActivity
import com.app.nytimes.databinding.ActivityMainBinding
import com.app.nytimes.viewmodels.ArticlesViewModel

class MainActivity : BaseActivity() {

    companion object {
        private val TAG = MainActivity::class.simpleName
    }

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ArticlesViewModel by viewModels()


    override fun getLayout(): ViewBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun init(savedInstanceState: Bundle?) {
        binding = getBinding() as ActivityMainBinding
        setSupportActionBar(binding.toolbar)
        viewModel.init(1)
        //listens to our data coming from get articles api
        viewModel.getLiveArticles()?.observe(this, { data ->
            binding.textViewDate.text = "Articles length is ${data?.size}"
        })
        // listen to get data articles api and show view accordingly
        viewModel.listenLoading().observe(this, { loading ->
            showProgressBar(loading)
        })
    }
}