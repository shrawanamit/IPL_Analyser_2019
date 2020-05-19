package com.analyser;

public class IplRunsWktsDAO {
    public String player;
    public int match;
    public int highestStrike;
    public float average;
    public int runs;
    public float strikeRate;
    public int noOfSix;
    public int noOfFour;
    public float economicsRate;


    public IplRunsWktsDAO(IplMostRunsCSV iplMostRunsCSV) {
         player = iplMostRunsCSV.player;
         runs = iplMostRunsCSV.runs;
         highestStrike = iplMostRunsCSV.highestStrike;
         average =iplMostRunsCSV. average;
         strikeRate=iplMostRunsCSV.strikeRate;
         noOfSix=iplMostRunsCSV.noOfSix;
         noOfFour=iplMostRunsCSV.noOfFour;
    }
    public IplRunsWktsDAO(IplMostWktsCSV iplMostWktsCSV) {
        player = iplMostWktsCSV.player;
        economicsRate = iplMostWktsCSV.economicsRate;
        strikeRate = iplMostWktsCSV.strikeRate;
        average =iplMostWktsCSV. average;
        runs = iplMostWktsCSV.runs;

    }
}
