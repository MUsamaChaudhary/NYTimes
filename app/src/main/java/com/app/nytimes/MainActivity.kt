package com.app.nytimes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        viewModel.getLiveArticles()?.observe(this, { data ->
            Log.d(TAG, "init: ${data?.size}")
        })
        viewModel.listenLoading().observe(this,{ loading ->
            showProgressBar(loading)
        })
    }
}