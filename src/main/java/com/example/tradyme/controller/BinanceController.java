package com.example.tradyme.controller;

import com.example.tradyme.service.BinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BinanceController {
    @Autowired
    private BinanceService service;

    @GetMapping(path = "/startWebsocket")
    public String start(){
        return service.start();
    }

    @GetMapping(path = "/subKline")
    public String subscribeKline(
            @RequestParam(value = "symbol", defaultValue = "BTCUSDT")
            String symbol) {
        return service.subscribeKline(symbol);
    }

    @GetMapping(path = "/closeWebsocketConnections")
    public String closeConnections() {
        return service.closeAllConnections();
    }
    @GetMapping(path = "/shutDownWebsocket")
    public String close() {
        return service.shutdown();
    }
}
