package com.example.tradyme.service;

import com.binance.connector.client.WebsocketClient;
import com.binance.connector.client.impl.WebsocketClientImpl;
import com.example.tradyme.model.KlineDPC;
import com.example.tradyme.model.KlineEventDPC;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.influxdb.client.JSON;
import com.influxdb.client.write.Point;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

@Service
public class BinanceService {
    @Autowired
    private InfluxService influxService;
    @Value("${binance.url}")
    private String url;

    @Autowired
    private WebsocketClient wsClient;

    private final ObjectMapper mapper = new ObjectMapper();
    private Queue<Integer> connections = new LinkedList<>();


    public String start() {
        // todo lock
        if(this.wsClient == null) {
            this.wsClient = new WebsocketClientImpl(url);
        }
        return "Successfully connected to Binance Websocket API";
    }


    public String subscribeKline(String symbol) {
//        if (wsClient == null) {
//            this.wsClient = new WebsocketClientImpl(url);
//        }
        int connIdx = wsClient.klineStream(symbol, "1s", ((response) -> {
            System.out.println("Event received: " + response);
            try {
//                KlineEventDPC event = mapper.readValue(response, KlineEventDPC.class);
//                KlineDPC klineDPC = event.getKline();
//                Point point = Point
//                        .measurement("KlineStream")
//                        .addTag("symbol", event.getSymbol())
//                        .addTag("closed", Boolean.toString(event.getKline().isClosed()))
//                        .addField("eventType", event.getEventType())
//                        .addField("eventTime", event.getEventTime())
//                        .addField("interval", event.getKline().getInterval())
//                        .addField("startTime", new BigInteger(event.getKline().getStartTime()))
//                        .addField("closeTime", new BigInteger(event.getKline().getCloseTime()))
//                        .addField("firstTradeID", new BigInteger(event.getKline().getFirstTradeID()))
//                        .addField("lastTradeID", new BigInteger(event.getKline().getLastTradeID()))
//                        .addField("openPrice", Float.parseFloat(event.getKline().getOpenPrice()))
//                        .addField("closePrice", Float.parseFloat(event.getKline().getClosePrice()))
//                        .addField("highPrice", Float.parseFloat(event.getKline().getHighPrice()))
//                        .addField("lowPrice", Float.parseFloat(event.getKline().getLowPrice()))
//                        .addField("baseAssetVolume", Float.parseFloat(event.getKline().getBaseAssetVolume()))
//                        .addField("numOfTrade", Integer.parseInt(event.getKline().getNumOfTrade()))
//                        .addField("quoteAssetVolume", Float.parseFloat(event.getKline().getQuoteAssetVolume()))
//                        .addField("takerBuyBaseAssetVolume", Float.parseFloat(event.getKline().getTakerBuyBaseAssetVolume()))
//                        .addField("takerBuyQuoteAssetVolume", Float.parseFloat(event.getKline().getTakerBuyQuoteAssetVolume()));

                JSONObject event = new JSONObject(response);
                String eventType = event.getString("e");
                BigInteger eventTime = event.getBigInteger("E");
                String eventSymbol = event.getString("s");
                JSONObject kline = event.getJSONObject("k");
                BigInteger startTime = kline.getBigInteger("t");
                BigInteger closeTime = kline.getBigInteger("T");
                String ksymbol = kline.getString("s");
                String interval = kline.getString("i");
                Integer firstTradeID = kline.getInt("f");
                Integer lastTradeID = kline.getInt("L");
                Double openPrice = kline.getDouble("o");
                Double closePrice = kline.getDouble("c");
                Double highPrice = kline.getDouble("h");
                Double lowPrice = kline.getDouble("l");
                Double baseAssetVolume = kline.getDouble("v");
                Integer numOfTrades = kline.getInt("n");
                Boolean closed = kline.getBoolean("x");
                Double quoteAssetVolume = kline.getDouble("q");
                Double takerBuyBaseAssetVolume = kline.getDouble("V");
                Double takerBuyQuoteAssetVolume = kline.getDouble("Q");
                Double ignore = kline.getDouble("B");

                Point point = Point
                        .measurement("Kline")
                        .addTag("symbol", ksymbol)
                        .addField("startTime", startTime)
                        .addField("closeTime", closeTime)
                        .addField("interval", interval)
                        .addField("firstTradeID", firstTradeID)
                        .addField("lastTradeID", lastTradeID)
                        .addField("openPrice", openPrice)
                        .addField("closePrice", closePrice)
                        .addField("highPrice", highPrice)
                        .addField("lowPrice", lowPrice)
                        .addField("baseAssetVolume", baseAssetVolume)
                        .addField("numOfTrades", numOfTrades)
                        .addField("closed", closed)
                        .addField("quoteAssetVolume", quoteAssetVolume)
                        .addField("takerBuyBaseAssetVolume", takerBuyBaseAssetVolume)
                        .addField("takerBuyQuoteAssetVolume", takerBuyQuoteAssetVolume)
                        .addField("ignore", ignore);
                influxService.writePoint(point);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }));
        connections.offer(connIdx);

        return "Successfully subscribed to the Binance Kline/Candlestick stream of symbol " + symbol;

//        this.wsClient.tradeStream(symbol, ((response) -> {
//            System.out.println("Event received: " + response);
//            try {
//                TradeEvent event = this.mapper.readValue(response, TradeEvent.class);
//                Point point = Point
//                        .measurement("TradeEvent")
//                        .addTag("symbol", event.getSymbol())
//                        .addField("event_type", event.getEvent_type())
//                        .addField("event_time", event.getEvent_time())
//                        .addField("trade_id", event.getTrade_id())
//                        .addField("price", event.getPrice())
//                        .addField("quantity", event.getQuantity())
//                        .addField("buyer_order_id", event.getBuyer_order_id())
//                        .addField("seller_order_id", event.getSeller_order_id())
//                        .addField("trade_time", event.getTrade_time())
//                        .addField("is_buyer_market_maker", event.getIs_buyer_market_maker())
//                        .addField("ignore", event.isIgnore())
//                        .time(Instant.now(), WritePrecision.NS);
//                InfluxService.writePoint(point);
//            } catch (Exception e) {
//                e.printStackTrace();
//                // throw new RuntimeException(e);
//            }
//        }));

    }

    public String closeAllConnections() {
        if (wsClient == null) {
            return "Websocket not found. Please initiate a websocket client first";
        }
        while (!connections.isEmpty()) {
            wsClient.closeConnection(connections.poll());
        }
        return "Successfully closed all websocket connections";
    }

    public String shutdown() {
        if (wsClient == null) {
            return "Websocket not found. Please initiate a websocket client first";
        }
        wsClient.closeAllConnections();
        return "Successfully shut down the websocket";
    }
}
