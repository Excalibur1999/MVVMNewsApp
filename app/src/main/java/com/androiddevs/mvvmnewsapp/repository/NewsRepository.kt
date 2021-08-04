package com.androiddevs.mvvmnewsapp.repository

import com.androiddevs.mvvmnewsapp.model.ArticleDatabase
import com.example.weatherapp.api.ApiService
import javax.inject.Inject


class NewsRepository @Inject constructor(
    db: ArticleDatabase,
    private val api: ApiService
) {
    val dao = db.getArticleDao()

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        api.getBreakingNews(countryCode, pageNumber)

}