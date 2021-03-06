package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.movieapp.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val movie: Movie = Movie(
        rating = 4.5F,
        genres = "Drama, Sport",
        creators = "Scott Frank, Alan Scott",
        actors = "Anya Taylor-Joy, Chloe Pirrie",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.movie = movie
        showToast()
    }

    private fun showToast() {
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            Toast.makeText(
                applicationContext,
                "Hey this is the toast you activated through the fab button",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}