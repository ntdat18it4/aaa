package com.example.androidadvanceday1.view

interface ILoginView {
    fun onLoginSuccess(message: String)
    fun onLoginError(message: String)
}