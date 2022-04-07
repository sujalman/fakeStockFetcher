package com.kuebiko.stockfetcher.service;

import com.kuebiko.stockfetcher.models.YahooStockResponse;

public interface YahooService {

    public YahooStockResponse fetchStockPrice(String symbol);

}
