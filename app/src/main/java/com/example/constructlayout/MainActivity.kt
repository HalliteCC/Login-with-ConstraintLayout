package com.example.constructlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.constructlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonA.setOnClickListener(this)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        supportActionBar?.hide()

    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_A){
            val email = binding.editEmail.text.toString()
            val password = binding.editSenha.text.toString()

            viewModel.doLogin(email, password)
        }

        viewModel.login().observe(this) {
            if (it) {
                Toast.makeText(applicationContext, "Success!", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(applicationContext, "Failure!", Toast.LENGTH_SHORT).show()
            }
        }
    }



}

