package com.androiddevs.mvvmnewsapp.response

import com.androiddevs.mvvmnewsapp.response.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)