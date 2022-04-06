package com.kuebiko.stockfetcher.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaFetcherConfig {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private String kafkaBootstrapAddress = "3.88.113.207:9092";


    @Bean
    public KafkaAdmin kafkaAdmin(){
        logger.info("Creating kafka admin");
        Map<String,Object> configs= new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaBootstrapAddress);
        logger.info("Created kafka admin with properties " + configs);
        return new KafkaAdmin(configs);
    }

}
