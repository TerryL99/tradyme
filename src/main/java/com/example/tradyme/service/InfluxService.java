package com.example.tradyme.service;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.write.Point;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class InfluxService {

    @Value("${influx.token}")
    private String token;

    @Value("${influx.bucket}")
    private String bucket;

    @Value("${influx.org}")
    private String org;

    @Value("${influx.url}")
    private String url;

    private InfluxDBClient dbClient;

    public String connect() {
        dbClient = InfluxDBClientFactory.create(url, token.toCharArray());
        return "Successfully connected to InfluxDB";
    }

    public void writePoint(Point point) throws NullPointerException {
        if (dbClient == null) {
            throw new NullPointerException("InfluxDB client is not initialized.");
        }
        WriteApiBlocking writeApi = dbClient.getWriteApiBlocking();
        writeApi.writePoint(bucket, org, point);
    }

    public String close() {
        if (dbClient == null) {
            throw new NullPointerException("InfluxDB client is not initialized.");
        }
        dbClient.close();
        return "Successfully disconnected from InfluxDB";
    }
}
