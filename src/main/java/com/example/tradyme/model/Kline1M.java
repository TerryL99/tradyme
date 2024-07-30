package com.example.tradyme.model;

import java.math.BigInteger;
import java.sql.Timestamp;

public class Kline1M {
    private Timestamp timestamp;
    private String symbol;
    private Float openPrice;
    private Float closePrice;
    private Float highPrice;
    private Float lowPrice;

    public Kline1M() {}

    public Kline1M(Timestamp timestamp, String symbol, Float openPrice, Float closePrice, Float highPrice,
                   Float lowPrice) {
        this.timestamp = timestamp;
        this.symbol = symbol;
        this.openPrice = openPrice;
        this.closePrice = closePrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Float getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(Float openPrice) {
        this.openPrice = openPrice;
    }

    public Float getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(Float closePrice) {
        this.closePrice = closePrice;
    }

    public Float getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Float highPrice) {
        this.highPrice = highPrice;
    }

    public Float getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Float lowPrice) {
        this.lowPrice = lowPrice;
    }
}
