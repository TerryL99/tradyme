package com.example.tradyme.model;

import com.fasterxml.jackson.annotation.JsonProperty;

// Unit data in Binance Kline/Candlestick Stream
public class KlineEventDPC {
    @JsonProperty("e")
    private String eventType;

    @JsonProperty("E")
    private String eventTime;

    @JsonProperty("s")
    private String symbol;

    @JsonProperty("k")
    private KlineDPC klineDPC;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public KlineDPC getKline() {
        return klineDPC;
    }

    public void setKline(KlineDPC klineDPC) {
        this.klineDPC = klineDPC;
    }
}
