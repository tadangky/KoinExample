package com.tadev.android.koin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tadev.android.koin.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel : MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            mainViewModel.getTodos()
        }

        binding.btn2.setOnClickListener {
            mainViewModel.comments()
        }

        binding.btn3.setOnClickListener {
            mainViewModel.posts()
        }

        binding.btn4.setOnClickListener {
            mainViewModel.login()
        }

        mainViewModel.todoList.observe(this) {
            Log.e("TATA", "MainAc observe todo: ${it.size}")
        }
    }
}
