package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.movieapp.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val movie: Movie = Movie(
        rating = 4.5F,
        genres = listOf("Drama", "Sport"),
        creators = listOf("Scott Frank", "Alan Scott"),
        actors = listOf("Anya Taylor-Joy", "Chloe Pirrie")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.movie = movie
        showToast()
    }

    private fun showToast() {
        binding.floatingActionButton.setOnClickListener {
            Toast.makeText(
                applicationContext,
                "Hey this is the toast you activated through the fab button",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}