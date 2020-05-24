package com.analyser;

public class BatsManAndBowlerData {
    public String player;
    public int highestStrike;
    public float average;
    public int runs;
    public float strikeRate;
    public int noOfSix;
    public int noOfFour;
    public float economicsRate;
    public int wikets;
    public int fourWikets;
    public String playerBatsman;

    public BatsManAndBowlerData(String player, int highestStrike, float average, int runs, float strikeRate, int noOfSix, int noOfFour, float economicsRate, int wikets, int fourWikets) {
        this.player = player;
        this.highestStrike = highestStrike;
        this.average = average;
        this.runs = runs;
        this.strikeRate = strikeRate;
        this.noOfSix = noOfSix;
        this.noOfFour = noOfFour;
        this.economicsRate = economicsRate;
        this.wikets = wikets;
        this.fourWikets = fourWikets;
    }
}
