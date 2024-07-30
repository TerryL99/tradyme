package com.example.tradyme.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public class TradeEvent {
    @JsonProperty("e")
    private String event_type;

    @JsonProperty("E")
    private BigInteger event_time;

    @JsonProperty("s")
    private String symbol;

    @JsonProperty("t")
    private BigInteger trade_id;

    @JsonProperty("p")
    private String price;

    @JsonProperty("q")
    private String quantity;

    @JsonProperty("b")
    private BigInteger buyer_order_id;

    @JsonProperty("a")
    private BigInteger seller_order_id;

    @JsonProperty("T")
    private BigInteger trade_time;

    @JsonProperty("m")
    private boolean is_buyer_market_maker;

    @JsonProperty("M")
    private boolean ignore;

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public BigInteger getEvent_time() {
        return event_time;
    }

    public void setEvent_time(BigInteger event_time) {
        this.event_time = event_time;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigInteger getTrade_id() {
        return trade_id;
    }

    public void setTrade_id(BigInteger trade_id) {
        this.trade_id = trade_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public BigInteger getBuyer_order_id() {
        return buyer_order_id;
    }

    public void setBuyer_order_id(BigInteger buyer_order_id) {
        this.buyer_order_id = buyer_order_id;
    }

    public BigInteger getSeller_order_id() {
        return seller_order_id;
    }

    public void setSeller_order_id(BigInteger seller_order_id) {
        this.seller_order_id = seller_order_id;
    }

    public BigInteger getTrade_time() {
        return trade_time;
    }

    public void setTrade_time(BigInteger trade_time) {
        this.trade_time = trade_time;
    }

    public boolean getIs_buyer_market_maker() {
        return is_buyer_market_maker;
    }

    public void setIs_buyer_market_maker(boolean is_buyer_market_maker) {
        this.is_buyer_market_maker = is_buyer_market_maker;
    }

    public boolean isIgnore() {
        return ignore;
    }

    public void setIgnore(boolean ignore) {
        this.ignore = ignore;
    }
}
