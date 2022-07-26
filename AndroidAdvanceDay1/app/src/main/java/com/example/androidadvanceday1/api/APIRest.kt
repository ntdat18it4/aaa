package com.example.androidadvanceday1.api

import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object APIRest {
    private const val BASE_URL = "http://www.mocky.io/"
    private var retrofit: Retrofit? = null
    val apiService: Api
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!.create(Api::class.java)
        }
}