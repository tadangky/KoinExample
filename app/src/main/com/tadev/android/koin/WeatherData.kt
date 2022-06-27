package com.tadev.android.koin

import com.google.gson.annotations.SerializedName
import org.json.JSONArray

data class WeatherDataResponse(
    @SerializedName("request") val request: WeatherRequestData,
    @SerializedName("location") val location: WeatherLocationData,
    @SerializedName("request") val current: WeatherCurrentData,

)

data class WeatherRequestData(
    @SerializedName("type") val type: String,
    @SerializedName("query") val query: String,
    @SerializedName("language") val language: String,
    @SerializedName("request") val request: String,
)

data class WeatherLocationData(
    @SerializedName("name") val name: String,
    @SerializedName("country") val country: String,
    @SerializedName("region") val region: String,
    @SerializedName("lat") val lat: String,
    @SerializedName("lon") val lon: String,
    @SerializedName("timezone_id") val timezone_id: String,
    @SerializedName("localtime") val localtime: String,
    @SerializedName("localtime_epoch") val localtime_epoch: Long,
    @SerializedName("utc_offset") val utc_offset: String,
)

data class WeatherCurrentData(
    @SerializedName("observation_time") val observation_time: String,
    @SerializedName("temperature") val temperature: Int,
    @SerializedName("weather_code") val weather_code: Int,
    @SerializedName("weather_icons") val weather_icons: JSONArray,
    @SerializedName("weather_descriptions") val weather_descriptions: JSONArray,
    @SerializedName("wind_speed") val wind_speed: String,
//    @SerializedName("localtime") val localtime: String,
//    @SerializedName("localtime_epoch") val localtime_epoch: Long,
//    @SerializedName("utc_offset") val utc_offset: String,
)
