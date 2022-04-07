package com.kuebiko.stockfetcher.models;

import java.util.Date;

public class YahooQuote {
    private String regularMarketPrice;
    private Date regularMarketTime;
    private String symbol;

    public String getRegularMarketPrice() {
        return regularMarketPrice;
    }

    public void setRegularMarketPrice(String regularMarketPrice) {
        this.regularMarketPrice = regularMarketPrice;
    }

    public Date getRegularMarketTime() {
        return regularMarketTime;
    }

    public void setRegularMarketTime(Date regularMarketTime) {
        this.regularMarketTime = regularMarketTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
