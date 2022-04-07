package com.kuebiko.stockfetcher.models;

import java.util.List;

public class YahooOptionChain {

    private List<YahooResult> result;

    public List<YahooResult> getResult() {
        return result;
    }

    public void setResult(List<YahooResult> result) {
        this.result = result;
    }
}
