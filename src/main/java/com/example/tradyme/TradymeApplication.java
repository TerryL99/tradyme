package com.example.tradyme;

import com.binance.connector.client.WebsocketClient;
import com.binance.connector.client.impl.WebsocketClientImpl;
import com.example.tradyme.model.TradeEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class TradymeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradymeApplication.class, args);
	}

}
