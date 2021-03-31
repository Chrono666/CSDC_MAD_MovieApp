package com.example.movieapp

import android.widget.RatingBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.io.Serializable

@BindingAdapter("android:text")
fun setText(view: TextView, list: List<String>) {
    view.text = list.joinToString(", ")
}

@BindingAdapter("android:rating")
fun setRating(ratingBar: RatingBar, float: Float) {
    when (float) {
        in (0.0f..5.0f) -> ratingBar.rating = float
        else -> ratingBar.rating = 0.0f
    }
}

data class Movie(
    val title: String,
    val description: String,
    val rating: Float,
    val genres: List<String?>,
    val creators: List<String>,
    val actors: List<String>,
    val picture: Int
): Serializable
