package com.github.m111q.homework5.controller;

import com.github.m111q.homework5.service.CurrencyPlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/currency")
public class CurrencyApi {

    private CurrencyPlayService currencyPlayService;

    @Autowired
    public CurrencyApi(CurrencyPlayService currencyPlayService) {
        this.currencyPlayService = currencyPlayService;
    }

    @GetMapping
    public ResponseEntity<String> beginGame() {
        return new ResponseEntity(currencyPlayService.askQuestion(), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/{rate}")
    public ResponseEntity checkAnswer(@PathVariable double rate) {
        return new ResponseEntity(currencyPlayService.playGame(rate), HttpStatus.OK);
    }
}
