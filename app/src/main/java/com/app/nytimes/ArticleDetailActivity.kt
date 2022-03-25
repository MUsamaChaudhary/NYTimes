package com.app.nytimes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.viewbinding.ViewBinding
import com.app.nytimes.base.BaseActivity
import com.app.nytimes.databinding.ActivityArticleDetailBinding
import com.app.nytimes.models.MostViewedArticle
import com.app.nytimes.utils.Utils
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
        Log.d(TAG, "updateUi: $articleModel")
        articleModel?.title?.let {
            binding.articleTitle.visibility = View.VISIBLE
            binding.articleTitle.text = it
        } ?: run {
            binding.articleTitle.visibility = View.GONE
        }
        articleModel?.section?.let {
            Utils.setViewVisibility(
                binding.articleSection,
                binding.articleSectionText,
                View.VISIBLE,
            )
            binding.articleSectionText.text = it
        } ?: run {
            Utils.setViewVisibility(binding.articleSection, binding.articleSectionText, View.GONE)
        }
        articleModel?.subsection?.let {
            if (it.isEmpty()) {
                Utils.setViewVisibility(
                    binding.articleSubSection,
                    binding.articleSubSectionText,
                    View.GONE,
                )
            } else {
                Utils.setViewVisibility(
                    binding.articleSubSection,
                    binding.articleSubSectionText,
                    View.VISIBLE,
                )
                binding.articleSubSectionText.text = it
            }
        } ?: run {
            Utils.setViewVisibility(
                binding.articleSubSection,
                binding.articleSubSectionText,
                View.GONE,
            )
        }
        articleModel?.source?.let {
            Utils.setViewVisibility(
                binding.articleSource,
                binding.articleSourceText,
                View.VISIBLE,
            )
            binding.articleSourceText.text = it
        } ?: run {
            Utils.setViewVisibility(binding.articleSource, binding.articleSourceText, View.GONE)
        }
        articleModel?.byline?.let {
            Utils.setViewVisibility(
                binding.articleByLine,
                binding.articleByLineText,
                View.VISIBLE,
            )
            binding.articleByLineText.text = it
        } ?: run {
            Utils.setViewVisibility(binding.articleByLine, binding.articleByLineText, View.GONE)
        }
        articleModel?.published_date?.let {
            Utils.setViewVisibility(
                binding.articlePublishedDate,
                binding.articlePublishedDateText,
                View.VISIBLE,
            )
            binding.articlePublishedDateText.text = it
        } ?: run {
            Utils.setViewVisibility(
                binding.articlePublishedDate,
                binding.articlePublishedDateText,
                View.GONE,
            )
        }

    }

}