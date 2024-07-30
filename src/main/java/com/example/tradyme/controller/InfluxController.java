package com.example.tradyme.controller;

import com.example.tradyme.service.InfluxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfluxController {
    @Autowired
    private InfluxService service;

    @GetMapping(path = "/connectDB")
    public String connect() {
        return service.connect();
    }

    @GetMapping(path = "disconnectDB")
    public String close() {
        return service.close();
    }
}
