package com.kevin.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.kevin.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //var number = 0

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.tvNumber.text  =viewModel.number.toString()
        binding.button.setOnClickListener {
//            number ++
//            binding.tvNumber.text = number.toString()

            viewModel.addNumber()
            binding.tvNumber.text  =viewModel.number.toString()
        }
    }
}