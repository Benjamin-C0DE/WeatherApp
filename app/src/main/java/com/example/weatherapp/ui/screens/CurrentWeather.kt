package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.models.Weather

@Composable
fun CurrentWeather(innerPadding: PaddingValues) {

    val weather = Weather(
        locationName = "Halifax",
        day = "Today",
        high = "16°C",
        low = "8°C",
        condition = "Partly cloudy",
        wind = "24 kph SW",
        humidity = "51%",
        iconResId = R.drawable.ic_partly_cloudy
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Icon
        weather.iconResId?.let {
            Image(
                painter = painterResource(id = it),
                contentDescription = weather.condition,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        Text(
            text = weather.locationName,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("High: ${weather.high}", style = MaterialTheme.typography.bodyLarge)
        Text("Low: ${weather.low}", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Condition: ${weather.condition}", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Wind: ${weather.wind}")
        Text("Humidity: ${weather.humidity}", style = MaterialTheme.typography.bodyLarge)
    }
}