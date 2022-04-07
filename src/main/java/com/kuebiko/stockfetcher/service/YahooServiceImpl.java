package com.kuebiko.stockfetcher.service;

import com.kuebiko.stockfetcher.models.YahooStockResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class YahooServiceImpl implements YahooService{

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public YahooStockResponse fetchStockPrice(String symbol) {
        logger.info("Calling yahoo api for " + symbol);
        // use rest template (how to get it)
        // return the data;

        // symbol $ price $ date

        return null;
    }
}
