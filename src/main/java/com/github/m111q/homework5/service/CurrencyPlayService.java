package com.github.m111q.homework5.service;

import com.github.m111q.homework5.model.currency.CurrencyCode;
import org.springframework.stereotype.Service;

@Service
public class CurrencyPlayService {

    private static final CurrencyCode MAIN_CURRENCY_CODE = CurrencyCode.PLN;
    private CurrencyService currencyService;
    private int answersCounter = 0;

    public CurrencyPlayService() {
        this.currencyService = new CurrencyService(MAIN_CURRENCY_CODE);
    }

    public String askQuestion() {
        String randomCurrency = currencyService.getRandomCurrencyInfo();
        String mainCurrency = currencyService.getMainCurrencyCode().toString();
        return "Wprowadź aktualny kurs " + randomCurrency + " względem " + mainCurrency + " uwzględniając 2 miejsca po przecinku";
    }

    public String playGame(double userAnswer) {
        answersCounter++;
        if (userAnswer > currencyService.getRandomCurrencyRate()) {
            return "Za dużo";
        }
        if (userAnswer < currencyService.getRandomCurrencyRate()) {
            return "Za mało";
        }
        resetGame();
        return "Dobrze, za " + answersCounter + " razem!";
    }

    public void resetGame() {
        currencyService = new CurrencyService(MAIN_CURRENCY_CODE);
    }

}
