package com.analyser;

import com.opencsv.bean.CsvBindByName;
//POS,PLAYER,Mat,Inns,Ov,Runs,Wkts,BBI,Avg,Econ,SR,4w,5w,
public class IplMostWktsCSV {
    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "SR", required = true)
    public float strikeRate;

    @CsvBindByName(column = "Econ", required = true)
    public float economicsRate;

    @CsvBindByName(column = "Avg", required = true)
    public float average;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @Override
    public String toString() {
        return "IplMostWktsCSV{" +
                "player='" + player + '\'' +
                ", match=" + strikeRate +
                ", inning=" + economicsRate+
                ", average=" + average +
                ", Runs=" + runs +
                '}';
    }
}
