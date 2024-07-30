package com.example.tradyme.configuration;

import com.binance.connector.client.WebsocketClient;
import com.binance.connector.client.impl.WebsocketClientImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Value("${binance.url}")
    private String url;

    @Bean
    public WebsocketClient getWsClient(){
        return new WebsocketClientImpl(url);
    }

}
