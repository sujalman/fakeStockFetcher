package com.kuebiko.stockfetcher.service;

import com.kuebiko.stockfetcher.models.YahooStockResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class YahooServiceImpl implements YahooService{

    @Value("${yahooapi.url}")
    private String url;

    @Value("${yahooapi.apiKey}")
    private String apiKey;

    @Autowired
    KafkaTemplate kafkaTemplate;

    String ALERT_TOPIC = "STOCK-MONITORING-TOPIC";


    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public YahooStockResponse fetchStockPrice(String symbol) {
        logger.info("Calling yahoo api for " + symbol);
        // use rest template (how to get it)
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-API-KEY",apiKey);
        HttpEntity<Object> entity = new HttpEntity<Object>(headers);

        RestTemplate restTemplate = new RestTemplate();
        String externalUrl = url+symbol;
        ResponseEntity<YahooStockResponse> response
                = restTemplate.exchange(externalUrl , HttpMethod.GET, entity, YahooStockResponse.class);

        // return the data;

        // symbol $ price $ date
        logger.info("Sending alerts to kafka ");

        logger.info("*********" +
                response.getBody().getOptionChain().getResult().get(0).getQuote().getSymbol()+" $ "+
                response.getBody().getOptionChain().getResult().get(0).getQuote().getRegularMarketPrice()+" $ "+
                response.getBody().getOptionChain().getResult().get(0).getQuote().getRegularMarketTime()+
                "*********");
        String message = response.getBody().getOptionChain().getResult().get(0).getQuote().getSymbol()+" $ "+
                response.getBody().getOptionChain().getResult().get(0).getQuote().getRegularMarketPrice()+" $ "+
                response.getBody().getOptionChain().getResult().get(0).getQuote().getRegularMarketTime();

        kafkaTemplate.send(ALERT_TOPIC, message);

        logger.info("Successfully sent to kafka as : " + message);

        return response.getBody();
    }
}
