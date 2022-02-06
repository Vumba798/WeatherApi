import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import java.net.HttpURLConnection
import java.net.URL


class WeatherApi {
    private val currentWeatherUrl = "http://api.openweathermap.org/data/2.5/weather?lat=55.7558&lon=37.6173&units=metric&appid=baf72db3654954826b60cb091c854cf6"
    //TODO
    private val weatherForecastUrl = "TODO"
    private val gson = Gson()

    suspend fun getUpdate() = coroutineScope {
        // contacts with WeatherApi via two different GET requests
        val currentWeatherJson = getApiResponse(currentWeatherUrl, this)
        //TODO
//        val weatherForecastJson = getApiResponse(weatherForecastUrl, this)
        println(currentWeatherJson)

    }
    private suspend fun getApiResponse(url: String, scope: CoroutineScope): String? {
        val defferedApiResponse = scope.async(Dispatchers.IO) {
            getRequest(url)
        }
        return defferedApiResponse.await().toString()
    }
    private fun getRequest(url: String) : String? {
        return with(URL(url).openConnection() as HttpURLConnection) {
            requestMethod = "GET"
            inputStream.bufferedReader().use {
                it.readText()
            }
        }
    }
}