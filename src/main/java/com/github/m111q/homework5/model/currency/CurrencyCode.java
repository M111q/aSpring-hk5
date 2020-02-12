package com.github.m111q.homework5.model.currency;

import java.util.Random;

public enum CurrencyCode {
    AED("UAE Dirham United Arab Emirates"),
    ARS("Argentine Peso	Argentina"),
    AUD("Australian Dollar	Australia"),
    BGN("Bulgarian Lev	Bulgaria"),
    BRL("Brazilian Real	Brazil"),
    BSD("Bahamian Dollar	Bahamas"),
    CAD("Canadian Dollar	Canada"),
    CHF("Swiss Franc	Switzerland"),
    CLP("Chilean Peso	Chile"),
    CNY("Chinese Renminbi	China"),
    COP("Colombian Peso	Colombia"),
    CZK("Czech Koruna	Czech Republic"),
    DKK("Danish Krone	Denmark"),
    DOP("Dominican Peso	Dominican Republic"),
    EGP("Egyptian Pound	Egypt"),
    EUR("Euro	EU Currency"),
    FJD("Fiji Dollar	Fiji"),
    GBP("Pound Sterling	United Kingdom"),
    GTQ("Guatemalan Quetzal	Guatemala"),
    HKD("Hong Kong Dollar	Hong Kong"),
    HRK("Croatian Kuna	Croatian"),
    HUF("Hungarian Forint	Hungary"),
    IDR("Indonesian Rupiah	Indonesia"),
    ILS("Israeli Shekel	Israel"),
    INR("Indian Rupee	India"),
    ISK("Icelandic Krona	Iceland"),
    JPY("Japanese Yen	Japan"),
    KRW("South Korean Won	Korea"),
    KZT("Kazakhstani Tenge	Kazakhstan"),
    MXN("Mexican Peso	Mexico"),
    MYR("Malaysian Ringgit	Malaysia"),
    NOK("Norwegian Krone	Norway"),
    NZD("New Zealand Dollar	New Zealand"),
    PAB("Panamanian Balboa	Panama"),
    PEN("Peruvian Nuevo Sol	Peru"),
    PHP("Philippine Peso	Philippines"),
    PKR("Pakistani Rupee	Pakistan"),
    PLN("Polish Zloty	Poland"),
    PYG("Paraguayan Guarani	Paraguay"),
    RON("Romanian Leu	Romania"),
    RUB("Russian Ruble	Russian Federation"),
    SAR("Saudi Riyal	Saudi Arabia"),
    SEK("Swedish Krona	Sweden"),
    SGD("Singapore Dollar	Singapore"),
    THB("Thai Baht	Thailand"),
    TRY("Turkish Lira	Turkey"),
    TWD("New Taiwan Dollar	Taiwan"),
    UAH("Ukrainian Hryvnia	Ukraine"),
    USD("US Dollar	United States"),
    UYU("Uruguayan Peso	Uruguay"),
    ZAR("South African Rand	South Africa");

    private String info;

    private CurrencyCode(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
