package com.androiddevs.mvvmnewsapp.repository

import com.androiddevs.mvvmnewsapp.dao.ArticleDao
import com.example.weatherapp.api.ApiService
import javax.inject.Inject


class NewsRepository @Inject constructor(
    val dao: ArticleDao,
    val api: ApiService
) {
}