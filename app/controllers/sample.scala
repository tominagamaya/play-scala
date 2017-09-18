package controllers

import org.json4s
import org.json4s.JValue
import org.json4s.native.JsonMethods
import play.api.libs.ws.WS

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class sample {

  def getWeatherJsonFromLivedoorApi(cityCode: String): JValue = {
    implicit val context = play.api.libs.concurrent.Execution.Implicits.defaultContext
    val weatherApiUrl: String = s"http://weather.livedoor.com/forecast/webservice/json/v1?city=$cityCode"
    val futureResponse = WS.url(weatherApiUrl).get().map {
      response => response.json.toString()
    }

    val response: String = Await.result(futureResponse, Duration.Inf)

    JsonMethods.parse(json4s.string2JsonInput(response))
  }
}
