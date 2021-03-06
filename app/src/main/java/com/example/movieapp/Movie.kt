package com.example.movieapp

data class Movie(
    var title: String = "The Queen's Gambit",
    var description: String,
    var rating: Float = 4.5F,
    var genres: String?,
    var creators: String,
    var actors: String,
)
