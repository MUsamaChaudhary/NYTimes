package com.app.nytimes.comparators

import android.util.Log
import com.app.nytimes.models.MostViewedArticle
import java.text.SimpleDateFormat
import java.util.*
import kotlin.Comparator

class ArticleTimeComp: Comparator<MostViewedArticle> {

    companion object {
        private val TAG = ArticleTimeComp::class.simpleName
    }

    override fun compare(p0: MostViewedArticle?, p1: MostViewedArticle?): Int {
        return try {
            val str1 = p0?.published_date
            val str2 = p1?.published_date
            val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val date1 = format.parse(str1)
            val date2 = format.parse(str2)
            return if(date1 != null && date2 != null)
                date2.compareTo(date1)
            else 0
        }catch (e: Exception){
            Log.d(TAG, "Article Comparator $e")
            0
        }
    }


}