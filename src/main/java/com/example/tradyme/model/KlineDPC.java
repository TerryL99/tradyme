package com.example.tradyme.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KlineDPC {
    @JsonProperty("t")
    private String startTime;

    @JsonProperty("T")
    private String closeTime;

    @JsonProperty("s")
    private String symbol;

    @JsonProperty("i")
    private String interval;

    @JsonProperty("f")
    private String firstTradeID;

    @JsonProperty("L")
    private String lastTradeID;

    @JsonProperty("o")
    private String openPrice;

    @JsonProperty("c")
    private String closePrice;

    @JsonProperty("h")
    private String highPrice;

    @JsonProperty("l")
    private String lowPrice;

    @JsonProperty("v")
    private String baseAssetVolume;

    @JsonProperty("n")
    private String numOfTrade;

    @JsonProperty("x")
    private boolean closed;

    @JsonProperty("q")
    private String quoteAssetVolume;

    @JsonProperty("V")
    private String takerBuyBaseAssetVolume;

    @JsonProperty("Q")
    private String takerBuyQuoteAssetVolume;

    @JsonProperty("B")
    private String ignore;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getFirstTradeID() {
        return firstTradeID;
    }

    public void setFirstTradeID(String firstTradeID) {
        this.firstTradeID = firstTradeID;
    }

    public String getLastTradeID() {
        return lastTradeID;
    }

    public void setLastTradeID(String lastTradeID) {
        this.lastTradeID = lastTradeID;
    }

    public String getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(String openPrice) {
        this.openPrice = openPrice;
    }

    public String getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(String closePrice) {
        this.closePrice = closePrice;
    }

    public String getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(String highPrice) {
        this.highPrice = highPrice;
    }

    public String getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(String lowPrice) {
        this.lowPrice = lowPrice;
    }

    public String getBaseAssetVolume() {
        return baseAssetVolume;
    }

    public void setBaseAssetVolume(String baseAssetVolume) {
        this.baseAssetVolume = baseAssetVolume;
    }

    public String getNumOfTrade() {
        return numOfTrade;
    }

    public void setNumOfTrade(String numOfTrade) {
        this.numOfTrade = numOfTrade;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean klineClosed) {
        this.closed = klineClosed;
    }

    public String getQuoteAssetVolume() {
        return quoteAssetVolume;
    }

    public void setQuoteAssetVolume(String quoteAssetVolume) {
        this.quoteAssetVolume = quoteAssetVolume;
    }

    public String getTakerBuyBaseAssetVolume() {
        return takerBuyBaseAssetVolume;
    }

    public void setTakerBuyBaseAssetVolume(String takerBuyBaseAssetVolume) {
        this.takerBuyBaseAssetVolume = takerBuyBaseAssetVolume;
    }

    public String getTakerBuyQuoteAssetVolume() {
        return takerBuyQuoteAssetVolume;
    }

    public void setTakerBuyQuoteAssetVolume(String takerBuyQuoteAssetVolume) {
        this.takerBuyQuoteAssetVolume = takerBuyQuoteAssetVolume;
    }

    public String getIgnore() {
        return ignore;
    }

    public void setIgnore(String ignore) {
        this.ignore = ignore;
    }
}
