package com.analyser;

public class IplRunsDAO {
    public String player;
    public int match;
    public int inning;
    public float average;
    public int runs;


    public IplRunsDAO(IplMostRunsCSV iplMostRunsCSV) {
         player = iplMostRunsCSV.player;
         match = iplMostRunsCSV.match;
         inning = iplMostRunsCSV.inning;
         average =iplMostRunsCSV. average;
    }
    public IplRunsDAO(IplMostWktsCSV iplMostWktsCSV) {
        player = iplMostWktsCSV.player;
        match = iplMostWktsCSV.match;
        inning = iplMostWktsCSV.inning;
        average =iplMostWktsCSV. average;
        runs = iplMostWktsCSV.runs;

    }
}
