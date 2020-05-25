package com.analyser;

import com.google.gson.Gson;
import java.util.*;
import java.util.stream.Collectors;

public class IplAnalyser {

    public enum IPL{RUNS,WICKET,BATTING_BOWLING}

//    public enum CompareType {BATSMAN_STRIKE, BATSMAN_AVERAGE, RUNS, SIX_AND_FOUR, BATSMAN_AVERAGE_WITH_STRIKE,
//        BATSMAN_STRIKE_WITH_SIX_AND_FOUR, BATSMAN_RUNS_WITH_AVERAGE, FOUR_AND_FIVE_WICKETS,
//        BOWLER_AVERAGE, BOWLER_STRIKE, BOWLER_WICKETS,BOWLER_STRIKE_WITH_FOUR_AND_FIVE_WICKETS,
//        ECONOMY,BOWLER_AVERAGE_WITH_STRIKE,BOWLER_WICKETS_WITH_AVERAGE,RUNS_WITH_WICKETS,
//        BATSMAN_AVERAGE_WITH_BOWLER_AVERAGE}


    Map<String,IplRunsWktsDAO> iplRunsWktsDAOMap;
    public IplAnalyser() {
        this.iplRunsWktsDAOMap = new HashMap<>();
    }

    public int loadIplFactsSheetData(IPL ipl , String... csvFilePath) throws IplAnalyserException{
        iplRunsWktsDAOMap =IplAdapterFactory.getIplData(ipl,csvFilePath);
        return iplRunsWktsDAOMap.size();
    }

    private String getSortedData(Comparator<IplRunsWktsDAO> averageComparator) throws IplAnalyserException {

        if(iplRunsWktsDAOMap == null || iplRunsWktsDAOMap.size() ==0 ) {
            throw new IplAnalyserException("no runs data",IplAnalyserException.ExceptionType.NO_IPL_DATA);
        }List sortedAvgRunsData = iplRunsWktsDAOMap.values()
                                    .stream()
                                    .sorted(averageComparator.reversed())
                                    .collect(Collectors.toList());
        String sortedAverageRunsDataInJson = new Gson().toJson(sortedAvgRunsData);
        return sortedAverageRunsDataInJson;
    }

    public String loadSortedOnStrikeRate() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> strikeRateComparator =Comparator.comparing(IPL -> IPL.strikeRate);
        return getSortedData(strikeRateComparator);
    }

    public String loadMaxSixInIpl() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> maxNoOfSixComparator =Comparator.comparing(IPL -> IPL.noOfSix);
        return getSortedData(maxNoOfSixComparator);

    }

    public String loadBatingStrikeRateFour() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> maxNoOfFourComparator =Comparator.comparing(IPL -> IPL.noOfFour);
        return getSortedData(maxNoOfFourComparator);
    }

    public String loadBestStrickRate() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> bestStrickRateComparator =Comparator.comparing(IPL -> IPL.highestStrike);
        return getSortedData(bestStrickRateComparator);
    }

    public String loadHighestRun() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> highestRunComparator =Comparator.comparing(IPL -> IPL.runs);
        return getSortedData(highestRunComparator);
    }

    public String loadBolingAverageOfPlayerIplWktsData() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> bolingAvgComparator =Comparator.comparing(IPL -> IPL. average);
        return getSortedData(bolingAvgComparator);
    }

    public String loadBestStrikeRateOfPlayerFromIplWktsData() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> strikerRateComparator =Comparator.comparing(IPL -> IPL.strikeRate);
        return getSortedData(strikerRateComparator);
    }

    public String loadBesteconomyRateOfPlayerFromIplWktsData() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> economyRateComparator =Comparator.comparing(IPL -> IPL.economicsRate);
        return getSortedData(economyRateComparator);
    }

    public String loadBestStrikingRate4W5WOfPlayerFromIplWktsData() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> sortByFiveAndFourWickets =Comparator.comparing(IPL -> (IPL.fourWikets + IPL.fiveWikets));
        Comparator<IplRunsWktsDAO> sortByStrikeWithFiveAndFourWickets=sortByFiveAndFourWickets.thenComparing(IPL -> IPL.strikeRate);
        return getSortedData(sortByStrikeWithFiveAndFourWickets);
    }


    public String getBestSortedOnRunsAndWicketData() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> avgComparator =Comparator.comparing(IPL -> (IPL.average +IPL.average));
        return getSortedData(avgComparator);
    }
    public String getAllRounderPlayerSortedOnRunsAndWicketData() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> avgComparator =Comparator.comparing(IPL -> IPL.average);
        return getSortedData(avgComparator);
    }
    public String loadSortedOnBattingAverage() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> averageComparator =Comparator.comparing(IPL -> IPL.average);
        return getSortedData(averageComparator);
    }

}
