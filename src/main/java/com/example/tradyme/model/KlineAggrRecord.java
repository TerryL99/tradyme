package com.example.tradyme.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class KlineAggrRecord {
    private String _measurement;
    private Timestamp _start;
    private Timestamp _stop;
    private Boolean closed;
    private String symbol;
    
    private String _field;
    private Float _value;
    private Timestamp _time;


}
