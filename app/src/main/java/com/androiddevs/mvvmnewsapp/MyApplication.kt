package com.androiddevs.mvvmnewsapp

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.androiddevs.mvvmnewsapp.dao.ArticleDao
import com.androiddevs.mvvmnewsapp.model.ArticleDatabase
import com.androiddevs.mvvmnewsapp.util.Constants.BASE_URL
import com.example.weatherapp.api.ApiService
import dagger.Provides
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@HiltAndroidApp
class MyApplication: Application(){

    @Provides
    @Singleton
    fun provideRetrofit():ApiService{
        val logging=HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ApiService::class.java)

    }

    @Provides
    @Singleton
    fun provideArticleDatabase(@ApplicationContext appContext: Context): ArticleDatabase {
        return Room.databaseBuilder(appContext, ArticleDatabase::class.java, "article_db.db")
            .build()
    }

    @Provides
    fun provideArticleDao(database: ArticleDatabase): ArticleDao {
        return database.getArticleDao()
    }

}