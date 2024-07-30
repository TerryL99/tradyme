package com.example.tradyme.model;

import java.math.BigInteger;

public class Kline {
    private BigInteger startTime;
    private BigInteger closeTime;
    private String symbol;
    private String interval;
    private Integer firstTradeID;
    private Integer lastTradeID;
    private Double openPrice;
    private Double closePrice;
    private Double highPrice;
    private Double lowPrice;
    private Double baseAssetVolume;
    private Integer numOfTrades;
    private Boolean closed;
    private Double quoteAssetVolume;
    private Double takerBuyBaseAssetVolume;
    private Double takerBuyQuoteAssetVolume;
    private Double ignore;

    public Kline() {}

    public Kline(BigInteger startTime, BigInteger closeTime, String symbol, String interval, Integer firstTradeID,
                 Integer lastTradeID, Double openPrice, Double closePrice, Double highPrice, Double lowPrice,
                 Double baseAssetVolume, Integer numOfTrades, Boolean closed, Double quoteAssetVolume,
                 Double takerBuyBaseAssetVolume, Double takerBuyQuoteAssetVolume, Double ignore) {
        this.startTime = startTime;
        this.closeTime = closeTime;
        this.symbol = symbol;
        this.interval = interval;
        this.firstTradeID = firstTradeID;
        this.lastTradeID = lastTradeID;
        this.openPrice = openPrice;
        this.closePrice = closePrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.baseAssetVolume = baseAssetVolume;
        this.numOfTrades = numOfTrades;
        this.closed = closed;
        this.quoteAssetVolume = quoteAssetVolume;
        this.takerBuyBaseAssetVolume = takerBuyBaseAssetVolume;
        this.takerBuyQuoteAssetVolume = takerBuyQuoteAssetVolume;
        this.ignore = ignore;
    }

    public BigInteger getStartTime() {
        return startTime;
    }

    public BigInteger getCloseTime() {
        return closeTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getInterval() {
        return interval;
    }

    public Integer getFirstTradeID() {
        return firstTradeID;
    }

    public Integer getLastTradeID() {
        return lastTradeID;
    }

    public Double getOpenPrice() {
        return openPrice;
    }

    public Double getClosePrice() {
        return closePrice;
    }

    public Double getHighPrice() {
        return highPrice;
    }

    public Double getLowPrice() {
        return lowPrice;
    }

    public Double getBaseAssetVolume() {
        return baseAssetVolume;
    }

    public Integer getNumOfTrades() {
        return numOfTrades;
    }

    public Boolean getClosed() {
        return closed;
    }

    public Double getQuoteAssetVolume() {
        return quoteAssetVolume;
    }

    public Double getTakerBuyBaseAssetVolume() {
        return takerBuyBaseAssetVolume;
    }

    public Double getTakerBuyQuoteAssetVolume() {
        return takerBuyQuoteAssetVolume;
    }

    public Double getIgnore() {
        return ignore;
    }

    public void setStartTime(BigInteger startTime) {
        this.startTime = startTime;
    }

    public void setCloseTime(BigInteger closeTime) {
        this.closeTime = closeTime;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public void setFirstTradeID(Integer firstTradeID) {
        this.firstTradeID = firstTradeID;
    }

    public void setLastTradeID(Integer lastTradeID) {
        this.lastTradeID = lastTradeID;
    }

    public void setOpenPrice(Double openPrice) {
        this.openPrice = openPrice;
    }

    public void setClosePrice(Double closePrice) {
        this.closePrice = closePrice;
    }

    public void setHighPrice(Double highPrice) {
        this.highPrice = highPrice;
    }

    public void setLowPrice(Double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public void setBaseAssetVolume(Double baseAssetVolume) {
        this.baseAssetVolume = baseAssetVolume;
    }

    public void setNumOfTrades(Integer numOfTrades) {
        this.numOfTrades = numOfTrades;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public void setQuoteAssetVolume(Double quoteAssetVolume) {
        this.quoteAssetVolume = quoteAssetVolume;
    }

    public void setTakerBuyBaseAssetVolume(Double takerBuyBaseAssetVolume) {
        this.takerBuyBaseAssetVolume = takerBuyBaseAssetVolume;
    }

    public void setTakerBuyQuoteAssetVolume(Double takerBuyQuoteAssetVolume) {
        this.takerBuyQuoteAssetVolume = takerBuyQuoteAssetVolume;
    }

    public void setIgnore(Double ignore) {
        this.ignore = ignore;
    }
}
