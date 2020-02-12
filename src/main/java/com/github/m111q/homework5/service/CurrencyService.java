package com.github.m111q.homework5.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.m111q.homework5.model.currency.CurrencyCode;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class CurrencyService {

    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    private final String randomCurrencyInfo;
    private final CurrencyCode mainCurrencyCode;
    private final CurrencyCode randomCurrency;
    private final String url;
    private final double randomCurrencyRate;


    public CurrencyService(CurrencyCode mainCurrencyCode) {
        this.mainCurrencyCode = mainCurrencyCode;
        this.randomCurrency = getRandomCurrency();
        this.url = API_URL + randomCurrency;
        this.randomCurrencyRate = getExchangeRateFromGivenCurrency(mainCurrencyCode);
        this.randomCurrencyInfo = getCurrencyInfo(randomCurrency);
        System.out.println(randomCurrencyInfo + " " + randomCurrencyRate );
    }

    public String getRandomCurrencyInfo() {
        return randomCurrencyInfo;
    }

    public CurrencyCode getMainCurrencyCode() {
        return mainCurrencyCode;
    }

    public double getRandomCurrencyRate() {
        return randomCurrencyRate;
    }

    //  @EventListener(ApplicationReadyEvent.class)
    private double getExchangeRateFromGivenCurrency(CurrencyCode currencyCode) {
        double currencyRate = getExchangeRates().get(currencyCode.toString()).doubleValue();
        return roundDouble(currencyRate);
    }

    private JsonNode getExchangeRates() {
        RestTemplate restTemplate = new RestTemplate();
        JsonNode exchangeRates = restTemplate.getForObject(url, JsonNode.class).get("rates");
        return exchangeRates;
    }

    private String getCurrencyInfo(CurrencyCode currencyCode) {
        return currencyCode + " : " +currencyCode.getInfo();
    }

    private double roundDouble(double doubleValue) {
        BigDecimal bd = BigDecimal.valueOf(doubleValue);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private CurrencyCode getRandomCurrency() {
        CurrencyCode[] currencyCodes = CurrencyCode.values();
        Random r = new Random();
        int random = r.nextInt(currencyCodes.length);
        if (!currencyCodes[random].equals(mainCurrencyCode)) {
            return currencyCodes[random];
        }
        return getRandomCurrency();
    }

}
