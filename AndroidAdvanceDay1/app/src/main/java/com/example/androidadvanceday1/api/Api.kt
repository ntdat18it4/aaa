package com.example.androidadvanceday1.api

import com.example.androidadvanceday1.model.User
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @FormUrlEncoded
    @POST("userLogin")
    fun userLogin(
        @Field("email") email :String,
        @Field("password") password :String

    ) : Call<List<User>>

//    @get:GET("/v3/6b2cab39-df28-477a-90ac-da9c64fcd77e")
//    val user: Call<List<User>>
}