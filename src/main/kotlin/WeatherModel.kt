data class ApiModel(
    val lat: Float,
    val lon: Float,
    val timezone: String,
    val timezone_offset: Int,
    val current: Current,
    val minutely: Array<Minute>,
    val hourly: Array<Hour>,
    val daily: Array<Day>,
    val alerts: Array<Alert>
) {
    data class Current(
        val dt: Int, // current time
        val sunrise: Int,
        val sunset: Int,
        val temp: Float,
        val feels_like: Float,
        val pressure: Int,
        val humidity: Int,
        val dew_point: Float,
        val uvi: Float, // current ultra-violet index
        val clouds: Int, // cloudness, %
        val visibility: Int,
        val wind_speed: Float,
        val wind_deg: Int,
        val wind_gust: Float,
        val rain: Rain,
        val snow: Snow,
        val weather: Array<Weather>
    ) {
        data class Rain(
            val `1h`: Float // rain volume for last hour
        )
        data class Snow(
            val `1h`: Float // snow volume for last hour
        )
        data class Weather(
            val id: Int, // weather condition id
            val main: String, // group of weather parameters (Rain, Snow, Extreme, etc.)
            val description: String,
            val icon: String // Weather icon id
        )
    }
    data class Minute(
        val dt: Int, // time of forecast
        val precipitation: Float // precipitation volume, mm
    )
    data class Hour(
        val dt: Int,
        val temp: Float,
        val fells_like: Float,
        val pressure: Int,
        val humidity: Int,
        val dew_point: Float,
        val uvi: Float,
        val clouds: Int,
        val visibility: Int,
        val rain: Rain,
        val snow: Snow,
        val wind_speed: Float,
        val wind_deg: Int,
        val wind_gust: Float,
        val weather: Array<Weather>,
        val pop: Float // probability of precipitation
    ) {
        data class Weather(
            val id: Int,
            val main: String,
            val description: String,
            val icon: String
        )
        data class Rain(
            val `1h`: Float // rain volume for last hour
        )
        data class Snow(
            val `1h`: Float // snow volume for last hour
        )
    }
    data class Day(
        val dt: Int,
        val sunrise: Int,
        val sunset: Int,
        val moonrise: Int,
        val moonset: Int,
        val moon_phase: Float,
        val temp: Temp,
        val feels_like: Feels_like,
        val pressure: Int,
        val humidity: Int,
        val dew_point: Float,
        val wind_speed: Float,
        val wind_deg: Int,
        val wind_gust: Float,
        val weather: Array<Weather>,
        val clouds: Int,
        val pop: Float,
        val snow: Float,
        val rain: Float,
        val uvi: Float
    ) {
        data class Temp(
            val morn: Float,
            val day: Float,
            val eve: Float,
            val night: Float,
            val min: Float,
            val max: Float
        )
        data class Feels_like(
            val morn: Float,
            val day: Float,
            val eve: Float,
            val night: Float
        )
        data class Weather(
            val id: Int,
            val main: String,
            val description: String,
            val icon: String
        )
    }
    data class Alert(
        val sender_name: String,
        val event: String,
        val start: Int,
        val end: Int,
        val description: String,
        val tags: Array<String>
    )
}