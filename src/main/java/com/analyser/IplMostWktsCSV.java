package com.analyser;

import com.opencsv.bean.CsvBindByName;
//POS,PLAYER,Mat,Inns,Ov,Runs,Wkts,BBI,Avg,Econ,SR,4w,5w,
public class IplMostWktsCSV {
    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int match;

    @CsvBindByName(column = "Inns", required = true)
    public int inning;

    @CsvBindByName(column = "Avg", required = true)
    public float average;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @Override
    public String toString() {
        return "IplMostWktsCSV{" +
                "player='" + player + '\'' +
                ", match=" + match +
                ", inning=" + inning +
                ", average=" + average +
                ", Runs=" + runs +
                '}';
    }
}
