package com.analyser;
import com.opencsv.bean.CsvBindByName;
public class IplMostRunsCSV {

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "HS", required = true)
    public int highestStrike;

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
                ", runs=" + runs +
                ", highestStrike=" + highestStrike +
                ", average=" + average +
                ", strikeRate=" + strikeRate +
                ", noOfFour=" + noOfFour +
                ", noOfSix=" + noOfSix +
                '}';
    }
}
