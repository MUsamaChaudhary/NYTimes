package com.app.nytimes.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.nytimes.R
import com.app.nytimes.databinding.LayoutArticlesItemBinding

import com.app.nytimes.models.MostViewedArticle
import com.app.nytimes.utils.Utils

class ArticlesAdapter(
    private var context: Context,
    private var articles: ArrayList<MostViewedArticle>,
    private var listener: ClickListener,
) : RecyclerView.Adapter<ArticlesAdapter.ViewHolder>() {

    companion object {
        private val TAG = ArticlesAdapter::class.simpleName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.layout_articles_item, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles[position]
        // set title
        article?.title?.let {
            Utils.setViewVisibility(holder.binding.articleTitle, null, View.VISIBLE)
            holder.binding.articleTitle.text = it
        } ?: run {
            Utils.setViewVisibility(holder.binding.articleTitle, null, View.GONE)
        }
        // set source
        article?.source?.let {
            Utils.setViewVisibility(holder.binding.articleSource, null, View.VISIBLE)
            holder.binding.articleSource.text = it
        } ?: run {
            Utils.setViewVisibility(holder.binding.articleSource, null, View.GONE)
        }
        // set section
        article?.section?.let {
            Utils.setViewVisibility(holder.binding.articleSections, null, View.VISIBLE)
            holder.binding.articleSections.text = it
        } ?: run {
            Utils.setViewVisibility(holder.binding.articleSections, null, View.GONE)
        }
        // set section
        article?.published_date?.let {
            Utils.setViewVisibility(holder.binding.timestamp, null, View.VISIBLE)
            holder.binding.timestamp.text = it
        } ?: run {
            Utils.setViewVisibility(holder.binding.timestamp, null, View.GONE)
        }

        // handle on click listner on article list items
        holder.binding.root.setOnClickListener {
            listener.onViewClick(article, position, it)
        }
        holder.binding.detail.setOnClickListener {
            listener.onViewClick(article, position, it)
        }

    }

    override fun getItemCount(): Int = articles.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = LayoutArticlesItemBinding.bind(itemView)
    }

    interface ClickListener {
        fun onViewClick(articleData: MostViewedArticle, position: Int, view: View)
    }
}