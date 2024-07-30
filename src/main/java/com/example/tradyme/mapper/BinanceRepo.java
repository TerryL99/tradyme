package com.example.tradyme.mapper;

import com.example.tradyme.model.Kline;
import com.example.tradyme.model.Kline1M;
import com.example.tradyme.model.KlineAggrRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BinanceRepo {

//    @Insert()
//    public int insert(Kline1M kline1m);


    @Select("SELECT * FROM kline_1m")
    public List<Kline> getAll();

    @Select("SELECT * FROM kline_1m WHERE symbol = #{symbol}")
    public List<Kline> getKlineBySymbol(String symbol);
}
