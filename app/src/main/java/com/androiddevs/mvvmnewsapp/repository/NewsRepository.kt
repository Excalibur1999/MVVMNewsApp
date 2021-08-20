package com.androiddevs.mvvmnewsapp.repository

import com.androiddevs.mvvmnewsapp.model.ArticleDatabase
import com.androiddevs.mvvmnewsapp.response.Article
import com.example.weatherapp.api.ApiService
import javax.inject.Inject


class NewsRepository @Inject constructor(
    val db: ArticleDatabase,
    private val api: ApiService
) {
    val dao = db.getArticleDao()

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article)=db.getArticleDao().upsert(article)

    fun getSavedNews()=db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article)=db.getArticleDao().deleteArticle(article)

}