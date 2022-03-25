package com.app.nytimes.models

import org.parceler.Parcel


data class MostViewedArticlesData(val status: String, val results: ArrayList<MostViewedArticle>?)

@Parcel
data class MostViewedArticle(
    var id: String? = null,
    var source: String? = null,
    var published_date: String? = null,
    var section: String? = null,
    var subsection: String? = null,
    var byline: String? = null,
    var title: String? = null,
    var abstract: String? = null
)
