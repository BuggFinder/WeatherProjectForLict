package com.example.sayed.weatherproject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by nurud on 2/26/2018.
 */

public interface WeatherServiceAPI {
    @GET()
    Call<ForecastWeatherResponse> getWeatherForecastResponses(@Url String stringUrl);

    @GET()
    Call<ForecastWeatherResponse> getWeatherHourForecastResponses(@Url String stringUrl);
}
