package com.app.nytimes.models


data class MostViewedArticlesData(val status: String, val items: ArrayList<MostViewedArticle>?)
data class MostViewedArticle(
    val id: Int,
    val source: String?,
    val published_date: String?,
    val section: String?,
    val subsection: String?,
    val byline: String?,
    val title: String?,
)
