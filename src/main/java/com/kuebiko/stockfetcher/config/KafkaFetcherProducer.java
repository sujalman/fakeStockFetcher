package com.kuebiko.stockfetcher.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaFetcherProducer {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private String kafkaBootstrapAddress = "3.88.113.207:9092";

    @Bean
    public ProducerFactory<String, String> producerFactory(){
        logger.info("Creating kafka Producer");

        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaBootstrapAddress);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        logger.info("Created kafka Producer with properties " + config);

        return new DefaultKafkaProducerFactory<>(config);

    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(){
        logger.info("Creating kafka template");
        return new KafkaTemplate<>(producerFactory());
    }
}



