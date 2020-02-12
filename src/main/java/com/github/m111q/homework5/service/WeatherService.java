package com.github.m111q.homework5.service;

import com.github.m111q.homework5.model.weather.WeatherInfo;
import com.github.m111q.homework5.model.weather.WeatherInfoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private static final String KEY = "APPID=e4ca033fa0ee55203d5de8891c986cc8";
    private static final String UNITS_METRIC = "units=metric";
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static final String LANG_PL = "lang=pl";

    public WeatherInfoDTO getWeatherInfoDTO(String city) {
        return new WeatherInfoDTO(getWeatherInfoFromApi(city));
    }

    private WeatherInfo getWeatherInfoFromApi(String city) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + city + "&" + KEY + "&" + UNITS_METRIC + "&" + LANG_PL;
        WeatherInfo weatherInfo = restTemplate.getForObject(url,
                WeatherInfo.class);
        return weatherInfo;
    }


}
