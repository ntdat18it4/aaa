package com.example.androidadvanceday1.model

import android.text.TextUtils
import android.util.Patterns
import com.google.gson.annotations.SerializedName

class User{
    @SerializedName("email")
    var email : String = ""
    @SerializedName("password")
    var password: String = ""
}


//class User(override val email: String, override val password: String): IUser {
//    override fun isDataValid(): Int {
//        if (TextUtils.isEmpty(email))
//            return 0
//        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
//            return 1
//        else if (password.length <= 6)
//            return 2
//        else
//            return -1
//    }
//
//}