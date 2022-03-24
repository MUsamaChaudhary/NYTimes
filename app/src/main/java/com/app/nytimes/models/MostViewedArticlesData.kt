package com.app.nytimes.models


data class MostViewedArticlesData(val status: String, val results: ArrayList<MostViewedArticle>?)
data class MostViewedArticle(
    val id: Long,
    val source: String?,
    val published_date: String?,
    val section: String?,
    val subsection: String?,
    val byline: String?,
    val title: String?,
)
