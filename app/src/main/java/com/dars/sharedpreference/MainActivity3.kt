package com.dars.sharedpreference

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dars.sharedpreference.Constants.Companion.baza
import com.dars.sharedpreference.Constants.Companion.login
import com.dars.sharedpreference.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    lateinit var binding: ActivityMain3Binding
    lateinit var preferenece:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        preferenece=getSharedPreferences(baza, MODE_PRIVATE)
        binding.btnSave.setOnClickListener {
            val edText=binding.edLogin.text.toString()
            saveLogin(edText)
            finish()
        }
    }

    fun saveLogin(loginText:String){
        val myEdit:SharedPreferences.Editor=preferenece.edit()
        myEdit.putString(login,loginText)
        myEdit.apply()
    }
}