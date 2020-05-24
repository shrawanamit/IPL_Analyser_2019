package com.analyser;
import com.opencsv.bean.CsvBindByName;
public class IplMostRunsCSV {
   // PLAYER,Mat,Inns,NO,Runs,HS,Avg,BF,SR,100,50,4s,6s

    @CsvBindByName(column = "PLAYER", required = true)
    public String playerBatsman;

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
                "player='" + playerBatsman + '\'' +
                ", runs=" + runs +
                ", highestStrike=" + highestStrike +
                ", average=" + average +
                ", strikeRate=" + strikeRate +
                ", noOfFour=" + noOfFour +
                ", noOfSix=" + noOfSix +
                '}';
    }
}
