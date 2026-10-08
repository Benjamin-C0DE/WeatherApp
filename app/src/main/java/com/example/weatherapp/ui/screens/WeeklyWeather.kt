package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
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
fun WeeklyWeather(innerPadding: PaddingValues) {

    val weeklyWeather = listOf(
        Weather(
            locationName = "Halifax",
            day = "Mon, Oct 12",
            high = "15°C",
            low = "8°C",
            condition = "Clody with low chance of sun",
            wind = "22 kph",
            humidity = "68%",
            iconResId = R.drawable.ic_partly_cloudy
        ),
        Weather(
            locationName = "Halifax",
            day = "Tue, Oct 13",
            high = "15°C",
            low = "7°C",
            condition = "Mainly Cloudy",
            wind = "15 kph",
            humidity = "55%",
            iconResId = R.drawable.ic_cloudy
        ),
        Weather(
            locationName = "Halifax",
            day = "Wed, Oct 14",
            high = "15°C",
            low = "7°C",
            condition = "cloudy with light rain",
            wind = "21 kph",
            humidity = "71%",
            iconResId = R.drawable.ic_overcast
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(MaterialTheme.colorScheme.background)
    ) {
        items(weeklyWeather) { dayWeather ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                // Day title
                Text(
                    text = dayWeather.day,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(12.dp))

                // icon
                dayWeather.iconResId?.let {
                    Image(
                        painter = painterResource(id = it),
                        contentDescription = dayWeather.condition,
                        modifier = Modifier.size(64.dp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }

                // High / Low
                Text("High: ${dayWeather.high}", style = MaterialTheme.typography.bodyLarge)
                Text("Low: ${dayWeather.low}", style = MaterialTheme.typography.bodyLarge)

                Spacer(modifier = Modifier.height(12.dp))

                // Condition, wind, humidity
                Text("Condition: ${dayWeather.condition}", style = MaterialTheme.typography.bodyLarge)
                Text("Wind: ${dayWeather.wind}")
                Text("Humidity: ${dayWeather.humidity}", style = MaterialTheme.typography.bodyLarge)
            }

            HorizontalDivider()
        }
    }
}