package com.kuebiko.stockfetcher.models;

public class YahooStockResponse {

    private YahooOptionChain optionChain;

    public YahooOptionChain getOptionChain() {
        return optionChain;
    }

    public void setOptionChain(YahooOptionChain optionChain) {
        this.optionChain = optionChain;
    }
}
