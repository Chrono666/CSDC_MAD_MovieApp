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
    var title: String,
    var description: String,
    var rating: Float,
    var genres: List<String?>,
    var creators: List<String>,
    var actors: List<String>,
): Serializable
