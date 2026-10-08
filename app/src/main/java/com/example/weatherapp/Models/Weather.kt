package com.example.weatherapp.models

data class Weather(
    val locationName: String,
    val day: String,
    val high: String,
    val low: String,
    val condition: String,
    val wind: String,
    val humidity: String,
    val iconResId: Int? // optional for later expansion
)
