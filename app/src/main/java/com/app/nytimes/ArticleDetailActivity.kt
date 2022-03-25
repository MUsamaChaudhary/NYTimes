package com.app.nytimes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
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
        Log.d(TAG, "updateUi: $articleModel")
        articleModel?.title?.let {
            binding.articleTitle.visibility= View.VISIBLE
            binding.articleTitle.text = it
        } ?: run {
            binding.articleTitle.visibility= View.GONE
        }
        articleModel?.section?.let {
            binding.articleSection.visibility= View.VISIBLE
            binding.articleSectionText.visibility= View.VISIBLE
            binding.articleSectionText.text = it
        } ?: run {
            binding.articleSection.visibility= View.GONE
            binding.articleSectionText.visibility= View.GONE
        }
        articleModel?.subsection?.let {
            if(it.isNullOrEmpty()){
                binding.articleSubSection.visibility= View.GONE
                binding.articleSubSectionText.visibility= View.GONE
            }else{
                binding.articleSubSection.visibility= View.VISIBLE
                binding.articleSubSectionText.visibility= View.VISIBLE
                binding.articleSubSectionText.text = it
            }
        } ?: run {
            binding.articleSubSection.visibility= View.GONE
            binding.articleSubSectionText.visibility= View.GONE
        }
        articleModel?.source?.let {
            binding.articleSource.visibility= View.VISIBLE
            binding.articleSourceText.visibility= View.VISIBLE
            binding.articleSourceText.text = it
        } ?: run {
            binding.articleSource.visibility= View.GONE
            binding.articleSourceText.visibility= View.GONE
        }
        articleModel?.byline?.let {
            binding.articleByLine.visibility= View.VISIBLE
            binding.articleByLineText.visibility= View.VISIBLE
            binding.articleByLineText.text = it
        } ?: run {
            binding.articleByLine.visibility= View.GONE
            binding.articleByLineText.visibility= View.GONE
        }
        articleModel?.published_date?.let {
            binding.articlePublishedDate.visibility= View.VISIBLE
            binding.articlePublishedDateText.visibility= View.VISIBLE
            binding.articlePublishedDateText.text = it
        } ?: run {
            binding.articlePublishedDate.visibility= View.GONE
            binding.articlePublishedDateText.visibility= View.GONE
        }

    }

}