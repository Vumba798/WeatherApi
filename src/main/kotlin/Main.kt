import com.google.gson.Gson

/*
data class WeatherModel (
    val coord: Coordinates,
    val weather: Array<Weather>,
    val main: Main,
    val visibility: Int,
    val wind: Wind,
    val clouds: Clouds,
    val rain: Rain,
    val snow: Snow,
    val sys: Sys,
    val timezone: Int,
    val name: String
) {
    data class Coordinates(
        val lon: String,
        val lat: String
    )
    data class Weather(
        val main: String,
        val description: String,
        val icon: String
    )
    data class Main(
        val temp: Float,
        val feels_like: Float,
        val temp_min: Float,
        val temp_max: Float,
        val pressure: Float,
        val humidity: Float,
        val grnd_value: Float
    )
    data class Wind(
        val speed: Float,
        val deg: Int,
        val gust: Float
    )
    data class Clouds(
        val all: Int
    )
    data class Rain(
        val `1h`: String,
        val `3h`: String
    )
    data class Snow(
        val `1h`: String,
        val `3h`: String
    )
    data class Sys(
        val country: String,
        val sunrise: Int,
        val sunset: Int
    )
}
 */
suspend fun main(args: Array<String>) {
    val obj = WeatherApi()
    obj.getUpdate()
    val gson = Gson()
    gson.
    val tmp = gson.fromJson("""{"coord":{"lon":37.6173,"lat":55.7558},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04n"}],"base":"stations","main":{"temp":-5.63,"feels_like":-8.36,"temp_min":-8.58,"temp_max":-4.87,"pressure":1004,"humidity":85,"sea_level":1004,"grnd_level":985},"visibility":2147,"wind":{"speed":1.6,"deg":184,"gust":2.42},"clouds":{"all":99},"dt":1644171945,"sys":{"type":2,"id":2018597,"country":"RU","sunrise":1644124453,"sunset":1644156780},"timezone":10800,"id":524901,"name":"Moscow","cod":200}""", WeatherModel::class.java)
    println(tmp)

}