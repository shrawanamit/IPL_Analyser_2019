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

    @CsvBindByName(column = "Wkts", required = true)
    public int wikets;

    @CsvBindByName(column = "4w", required = true)
    public int fourWikets;

    @CsvBindByName(column = "5w", required = true)
    public int fiveWikets;


    @Override
    public String toString() {
        return "IplMostWktsCSV{" +
                "player='" + player + '\'' +
                ", strikeRate=" + strikeRate +
                ", economicsRate=" + economicsRate +
                ", average=" + average +
                ", runs=" + runs +
                ", wikets=" + wikets +
                ", fourWikets=" + fourWikets +
                ", fiveWikets=" + fiveWikets +
                '}';
    }
}
