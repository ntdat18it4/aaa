package com.example.androidadvanceday1.model

import com.google.gson.annotations.SerializedName

interface IUser {

    val email: String
    val password: String
    fun isDataValid(): Int
}