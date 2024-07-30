package com.example.tradyme.controller;

import com.example.tradyme.mapper.BinanceRepo;
import com.example.tradyme.model.Kline;
import com.example.tradyme.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppController {
    @Autowired
    private AppService service;

//    // allow flux db schudeler job to insert data
//    @PostMapping
//    public void insert(){
//        repo.insert();
//    }

    @GetMapping(path = "/api/getKlineAll")
    public List<Kline> getAll() {
        return service.getAll();
    }


    // allow external user(chrome, front end, postman, etc) to get the data
    @GetMapping(path = "/api/getKline/{symbol}")
    public List<Kline> getKline(
            @PathVariable("symbol")
            String symbol,
            @RequestParam(value = "interval", defaultValue = "1m")
            String interval) {
        return service.getKline(symbol, interval);
    }
}
