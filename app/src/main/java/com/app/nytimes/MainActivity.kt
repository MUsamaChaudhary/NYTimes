package com.app.nytimes

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.app.nytimes.adapters.ArticlesAdapter
import com.app.nytimes.base.BaseActivity
import com.app.nytimes.comparators.ArticleTimeComp
import com.app.nytimes.databinding.ActivityMainBinding
import com.app.nytimes.models.MostViewedArticle
import com.app.nytimes.utils.Utils
import com.app.nytimes.utils.Utils.makeSnackBar
import com.app.nytimes.viewmodels.ArticlesViewModel
import org.parceler.Parcels

class MainActivity : BaseActivity(), ArticlesAdapter.ClickListener {

    companion object {
        private val TAG = MainActivity::class.simpleName
        const val KEY_JOB_MODEL = "KeyArticleModel"
    }

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ArticlesViewModel by viewModels()
    private lateinit var adapter: ArticlesAdapter
    private var articlesList = ArrayList<MostViewedArticle>()

    override fun getLayout(): ViewBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun init(savedInstanceState: Bundle?) {
        binding = getBinding() as ActivityMainBinding
        setSupportActionBar(binding.toolbar)

        // set recycler view data
        initRecyclerView()

        // initializing view model
        viewModel.init(1)
        //listens to our data coming from get articles api
        viewModel.getLiveArticles()?.observe(this, { data ->
            articlesList.clear()
            data?.let {
                if (it.isNotEmpty()) {
                    binding.noArticle.visibility = View.GONE
                    articlesList.addAll(data)
                    articlesList.sortWith(ArticleTimeComp())
                } else {
                    binding.noArticle.visibility = View.VISIBLE
                }
            } ?: kotlin.run {
                binding.noArticle.visibility = View.VISIBLE
            }
            adapter.notifyDataSetChanged()
        })
        // listen to get data articles api and show loading view accordingly
        viewModel.listenLoading().observe(this, { loading ->
            showProgressBar(loading)
        })
        //// listen to get data articles api and show swipe loading view accordingly
        viewModel.listenSwipeLoading().observe(this, { loading ->
            binding.swipeRefresh.isRefreshing = loading
        })


        // call api on refresh listner
        binding.swipeRefresh.setOnRefreshListener {
            if (Utils.isNetworkAvailable(this)) {
                viewModel.loadArticles(1)
            } else {
                binding.swipeRefresh.isRefreshing = false
                binding.root.makeSnackBar("Network not available")
            }
        }
    }

    private fun initRecyclerView() {
        adapter = ArticlesAdapter(this, articlesList, this)
        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = adapter
    }

    override fun onViewClick(articleData: MostViewedArticle, position: Int, view: View) {
        startActivity(
            Intent(
                this@MainActivity,
                ArticleDetailActivity::class.java
            ).apply {
                putExtra(KEY_JOB_MODEL, Parcels.wrap(articleData))
            })
    }
}