package com.kuebiko.stockfetcher.controller;

import com.kuebiko.stockfetcher.models.YahooStockResponse;
import com.kuebiko.stockfetcher.service.YahooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1")
public class StockController {

    @Autowired
    YahooService yahooService;

    @RequestMapping(value = "/fetch", method = RequestMethod.GET)
    public YahooStockResponse fetch(@RequestParam String symbol) {
        return yahooService.fetchStockPrice(symbol);
    }
}
