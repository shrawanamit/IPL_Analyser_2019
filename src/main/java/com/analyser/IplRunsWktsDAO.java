package com.analyser;

public class IplRunsWktsDAO {
    public String playerBatsman;
    public String playerBowler;
    public int highestStrike;
    public float batsmanAverage;
    public float bowlerAverage;
    public int runs;
    public float strikeRate;
    public int noOfSix;
    public int noOfFour;
    public float economicsRate;
    public int wikets;
    public int fourWikets;


    public IplRunsWktsDAO(IplMostRunsCSV iplMostRunsCSV) {
         playerBatsman = iplMostRunsCSV.playerBatsman;
         runs = iplMostRunsCSV.runs;
         highestStrike = iplMostRunsCSV.highestStrike;
         batsmanAverage =iplMostRunsCSV. average;
         strikeRate=iplMostRunsCSV.strikeRate;
         noOfSix=iplMostRunsCSV.noOfSix;
         noOfFour=iplMostRunsCSV.noOfFour;
    }
    public IplRunsWktsDAO(IplMostWktsCSV iplMostWktsCSV) {
        playerBowler = iplMostWktsCSV.playerBowler;
        economicsRate = iplMostWktsCSV.economicsRate;
        strikeRate = iplMostWktsCSV.strikeRate;
        bowlerAverage =iplMostWktsCSV. average;
        runs = iplMostWktsCSV.runs;
        fourWikets= iplMostWktsCSV.fourWikets;
        wikets= iplMostWktsCSV.wikets;

    }
}
