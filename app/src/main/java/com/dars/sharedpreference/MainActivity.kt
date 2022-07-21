package com.dars.sharedpreference

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.CompoundButton
import android.widget.Toast
import com.dars.sharedpreference.Constants.Companion.login
import com.dars.sharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var preferenece: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.edText.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD or InputType.TYPE_CLASS_TEXT
        preferenece = getSharedPreferences(Constants.baza, MODE_PRIVATE)
        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener {
            val savedLogin: String = preferenece.getString(login, null).toString()
            val edText = binding.edText.text.toString()
            if (savedLogin.equals(edText)) {
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Xato", Toast.LENGTH_SHORT).show()
            }
        }
        binding.checkBox.setOnCheckedChangeListener(object :
            CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                if (p1) {
                    binding.edText.inputType = InputType.TYPE_CLASS_TEXT
                    Toast.makeText(this@MainActivity, p1.toString(), Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, p1.toString(), Toast.LENGTH_SHORT).show()
                    binding.edText.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD or InputType.TYPE_CLASS_TEXT
                }
            }
        })
    }
}