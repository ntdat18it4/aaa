package com.example.androidadvanceday1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.androidadvanceday1.api.APIRest
import com.example.androidadvanceday1.api.Api
import com.example.androidadvanceday1.databinding.ActivityLoginBinding
import com.example.androidadvanceday1.model.User
import com.example.androidadvanceday1.presenter.ILoginPresenter
import com.example.androidadvanceday1.presenter.LoginPresenter
import com.example.androidadvanceday1.view.ILoginView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity(), ILoginView, Callback<List<User>> {

    var user: MutableList<User> = mutableListOf()
    internal lateinit var loginPresenter: ILoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()

        loginPresenter = LoginPresenter(this)

        binding.btnLoginLogin.setOnClickListener {
            //loginPresenter.onLogin(binding.etLoginUsername.text.toString(), binding.etLoginPassword.text.toString())
            val email = binding.etLoginUsername.text.toString().trim()
            val password = binding.etLoginPassword.text.toString().trim()

            if (email.isEmpty()){
                binding.etLoginUsername.error = "Email is required"
                binding.etLoginUsername.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty()){
                binding.etLoginPassword.error = "Password is required"
                binding.etLoginPassword.requestFocus()
                return@setOnClickListener
            }

            APIRest.apiService.userLogin(email, password).enqueue(object : Callback<User>(){
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    TODO("Not yet implemented")
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }
    }

    override fun onLoginSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onLoginError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun initData(){
        APIRest.apiService.user.enqueue(this)
    }

    override fun onResponse(call: Call<List<User>>?, response: Response<List<User>>?) {
        if(response==null|| response.body()==null){
            return
        }
        user.addAll(response.body()!!)
    }

    override fun onFailure(call: Call<List<User>>?, t: Throwable?) {
        Toast.makeText(applicationContext,"Error",Toast.LENGTH_SHORT).show();
    }


}

