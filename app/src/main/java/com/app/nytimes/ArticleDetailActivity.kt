package com.app.nytimes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewbinding.ViewBinding
import com.app.nytimes.base.BaseActivity
import com.app.nytimes.databinding.ActivityArticleDetailBinding
import com.app.nytimes.models.MostViewedArticle
import org.parceler.Parcels

class ArticleDetailActivity : BaseActivity() {

    companion object {
        private val TAG = ArticleDetailActivity::class.simpleName
    }

    private lateinit var binding: ActivityArticleDetailBinding
    private lateinit var articleModel: MostViewedArticle
    override fun getLayout(): ViewBinding {
        return ActivityArticleDetailBinding.inflate(layoutInflater)
    }

    override fun init(savedInstanceState: Bundle?) {
        binding = getBinding() as ActivityArticleDetailBinding
        setSupportActionBar(binding.toolbar)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
        articleModel = Parcels.unwrap(intent?.getParcelableExtra(MainActivity.KEY_JOB_MODEL))
        updateUi(articleModel)

    }

    private fun updateUi(articleModel: MostViewedArticle?) {
        articleModel?.title?.let {
            binding.articleTitle.text = it
        }
        articleModel?.section?.let {
            binding.articleSectionText.text = it
        }
        articleModel?.subsection?.let {
            binding.articleSubSectionText.text = it
        }
        articleModel?.source?.let {
            binding.articleSourceText.text = it
        }
        articleModel?.byline?.let {
            binding.articleByLineText.text = it
        }
        articleModel?.published_date?.let {
            binding.articlePublishedDateText.text = it
        }

    }

}