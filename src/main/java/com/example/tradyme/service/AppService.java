package com.example.tradyme.service;

import com.example.tradyme.mapper.BinanceRepo;
import com.example.tradyme.model.Kline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AppService {
    @Autowired
    private BinanceRepo repo;

    public List<Kline> getAll() {
        return repo.getAll();
    }

    public List<Kline> getKline(String symbol, String interval) {
        List<Kline> kline_1m = repo.getKlineBySymbol(symbol);
        List<Kline> result = new ArrayList<>();
        int step = 1;
        switch (interval) {
            case "1m": step = 1; break;
            case "5m": step = 5; break;
            case "10m": step = 10; break;
            case "15m": step = 15; break;
            case "30m": step = 30; break;
            case "1h": step = 60; break;
            default: break;
        }
        if (step == 1) return kline_1m;
        int numNewKlines = (int) Math.ceil((double) kline_1m.size() / step);
        for (int i = 0; i < numNewKlines; i++) {
            int firstIdx = i * step;
            int lastIdx = (i == numNewKlines-1) ? (kline_1m.size()-1) : (i * step + step - 1);
            BigInteger startTime = (BigInteger) getOrDefault(kline_1m.get(firstIdx).getStartTime(), BigInteger.ZERO);
            BigInteger closeTime = (BigInteger) getOrDefault(kline_1m.get(lastIdx).getCloseTime(), BigInteger.ZERO);
            String ksymbol = symbol;
            String kinterval = interval;
            Integer firstTradeID = (Integer) getOrDefault(kline_1m.get(firstIdx).getFirstTradeID(), 0);
            Integer lastTradeID = (Integer) getOrDefault(kline_1m.get(lastIdx).getLastTradeID(), 0);
            Double openPrice = (Double) getOrDefault(kline_1m.get(firstIdx).getOpenPrice(), 0.0);
            Double closePrice = (Double) getOrDefault(kline_1m.get(lastIdx).getClosePrice(), 0.0);
            Double highPrice = 0.0;
            Double lowPrice = 0.0;
            Double baseAssetVolume = 0.0;
            Integer numOfTrades = 0;
            Boolean close = (Boolean) getOrDefault(kline_1m.get(lastIdx).getClosed(), false);
            Double quoteAssetVolume = 0.0;
            Double takerBuyBaseAssetVolume = 0.0;
            Double takerBuyQuoteAssetVolume = 0.0;
            Double ignore = 0.0;

            for (int idx = firstIdx; idx <= lastIdx; idx++) {
                Kline kline = kline_1m.get(idx);
                highPrice = Math.max(highPrice, kline.getHighPrice());
                lowPrice = Math.min(lowPrice, kline.getLowPrice());
                baseAssetVolume = Math.max(baseAssetVolume, kline.getBaseAssetVolume());
                numOfTrades += kline.getNumOfTrades();
                quoteAssetVolume = Math.max(quoteAssetVolume, kline.getQuoteAssetVolume());
                takerBuyBaseAssetVolume = Math.max(takerBuyBaseAssetVolume, kline.getTakerBuyBaseAssetVolume());
                takerBuyQuoteAssetVolume = Math.max(takerBuyQuoteAssetVolume, kline.getTakerBuyQuoteAssetVolume());
            }
            result.add(new Kline(startTime, closeTime, ksymbol, kinterval, firstTradeID, lastTradeID, openPrice,
                    closePrice, highPrice, lowPrice, baseAssetVolume, numOfTrades, close, quoteAssetVolume,
                    takerBuyBaseAssetVolume, takerBuyQuoteAssetVolume, ignore));
        }
        return result;
    }

    public Object getOrDefault(Object getValue, Object defaultValue) {
        if (getValue == null) return defaultValue;
        return getValue;
    }
}
