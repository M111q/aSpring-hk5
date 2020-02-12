package com.github.m111q.homework5.controller;

import com.github.m111q.homework5.model.weather.WeatherInfoDTO;
import com.github.m111q.homework5.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherApi {

    private WeatherService weatherService;

    @Autowired
    public WeatherApi(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{cityName}")
    public ResponseEntity<WeatherInfoDTO> getWeatherByCityName(@PathVariable String cityName) {
        return new ResponseEntity<WeatherInfoDTO>(weatherService.getWeatherInfoDTO(cityName), HttpStatus.OK);
    }

    //@EventListener(ApplicationReadyEvent.class)


//    private WeatherInfo getCatFact() {
//        RestTemplate restTemplate = new RestTemplate();
////        AnimalFact animalFact = restTemplate.getForObject("https://cat-fact.herokuapp.com/facts/random", AnimalFact.class);
////        JsonNode image = restTemplate.getForObject("https://aws.random.cat/meow", JsonNode.class).get("file");
////        animalFact.setSrc(image.asText());
//        return "duuupa";
//    }


}
