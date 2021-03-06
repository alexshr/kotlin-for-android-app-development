import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope

import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class User
class Location
class Weather
suspend fun fetchUser(id: Int): User = User()
suspend fun fetchLocation(user: User): Location = Location()
suspend fun fetchWeather(location: Location): Weather = Weather()
fun updateUi(weather: Weather) {}
// --------------

suspend fun updateWeather(userId: Int) {
  val user = fetchUser(userId)
  val location = fetchLocation(user)
  val weatherData = fetchWeather(location)

  withContext(Dispatchers.Main) {
    updateUi(weatherData)
  }
}

// Call-site
GlobalScope.launch { updateWeather() }
