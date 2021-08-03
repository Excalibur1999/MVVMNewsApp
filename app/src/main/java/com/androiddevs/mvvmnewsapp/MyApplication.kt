package com.androiddevs.mvvmnewsapp

import android.app.Application
import com.androiddevs.mvvmnewsapp.util.Constants.BASE_URL
import com.example.weatherapp.api.ApiService
import dagger.Provides
import dagger.hilt.android.HiltAndroidApp
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
        val client=OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
       return Retrofit.Builder()
            .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ApiService::class.java)

    }

}