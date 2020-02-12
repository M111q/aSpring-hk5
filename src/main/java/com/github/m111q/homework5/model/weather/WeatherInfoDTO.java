package com.github.m111q.homework5.model.weather;


public class WeatherInfoDTO {
    private String name;
    private String country;
    private String mainDescription;
    private String description;
    private Double temp;
    private Double feelsLike;
    private Double tempMin;
    private Double tempMax;
    private Integer pressure;
    private Integer humidity;
    private String iconURL;


    public WeatherInfoDTO(WeatherInfo weatherInfo) {
        final String ICON = weatherInfo.getWeather().get(0).getIcon();
        this.name = weatherInfo.getName();
        this.country = weatherInfo.getSys().getCountry();
        this.mainDescription = weatherInfo.getWeather().get(0).getMain();
        this.description = weatherInfo.getWeather().get(0).getDescription();
        this.temp = weatherInfo.getMain().getTemp();
        this.feelsLike = weatherInfo.getMain().getFeelsLike();
        this.tempMin = weatherInfo.getMain().getTempMin();
        this.tempMax = weatherInfo.getMain().getTempMax();
        this.pressure = weatherInfo.getMain().getPressure();
        this.humidity = weatherInfo.getMain().getHumidity();
        this.iconURL = "http://openweathermap.org/img/wn/" + ICON + "@2x.png";

    }

    public String getMainDescription() {
        return mainDescription;
    }

    public void setMainDescription(String mainDescription) {
        this.mainDescription = mainDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(Double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "WeatherInfoDTO{" +
                "mainDescription='" + mainDescription + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + iconURL + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", temp=" + temp +
                ", feelsLike=" + feelsLike +
                ", tempMin=" + tempMin +
                ", tempMax=" + tempMax +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                '}';
    }
}
