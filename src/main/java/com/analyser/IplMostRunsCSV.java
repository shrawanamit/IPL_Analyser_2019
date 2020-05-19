package com.analyser;
import com.opencsv.bean.CsvBindByName;
public class IplMostRunsCSV {
   // PLAYER,Mat,Inns,NO,Runs,HS,Avg,BF,SR,100,50,4s,6s

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int match;

    @CsvBindByName(column = "Inns", required = true)
    public int inning;

    @CsvBindByName(column = "Avg", required = true)
    public float average;

    @CsvBindByName(column = "SR", required = true)
    public float strikeRate;

    @CsvBindByName(column = "6s", required = true)
    public int noOfSix;

    @CsvBindByName(column = "4s", required = true)
    public int noOfFour;

    @Override
    public String toString() {
        return "IplMostRunsCSV{" +
                "player='" + player + '\'' +
                ", match=" + match +
                ", inning=" + inning +
                ", average=" + average +
                ", strikeRate=" + strikeRate +
                ", noOfFour=" + noOfFour +
                ", noOfSix=" + noOfSix +
                '}';
    }
}
