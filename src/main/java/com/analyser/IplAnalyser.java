package com.analyser;

import com.google.gson.Gson;
import java.util.*;
import java.util.stream.Collectors;

public class IplAnalyser {

    public enum IPL{RUNS,WICKET,BATTING_BOWLING};

    List<IplRunsWktsDAO> iplRunsWiktsList;
    public IplAnalyser() {
        this.iplRunsWiktsList = new ArrayList<>();
    }

    public int loadIplFactsSheetData(IPL ipl , String... csvFilePath) throws IplAnalyserException{
        iplRunsWiktsList=IplAdapterFactory.getIplData(ipl,csvFilePath);
        return iplRunsWiktsList.size();
    }


    public String loadSortedOnBattingAverage() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> averageComparator =Comparator.comparing(IPL -> IPL.batsmanAverage);
        return sort(averageComparator);
    }

    private String sort(Comparator<IplRunsWktsDAO> averageComparator) throws IplAnalyserException {

        if(iplRunsWiktsList == null || iplRunsWiktsList.size() ==0 ) {
            throw new IplAnalyserException("no runs data",IplAnalyserException.ExceptionType.NO_IPL_DATA);
        }List sortedAvgRunsData = iplRunsWiktsList
                                    .stream()
                                    .sorted(averageComparator)
                                    .collect(Collectors.toList());
            String sortedAverageRunsDataInJson = new Gson().toJson(sortedAvgRunsData);
            return sortedAverageRunsDataInJson;
    }

    public String loadSortedOnStrikeRate() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> strikeRateComparator =Comparator.comparing(IPL -> IPL.strikeRate);
        return sort(strikeRateComparator);
    }

    public String loadMaxSixInIpl() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> maxNoOfSixComparator =Comparator.comparing(IPL -> IPL.noOfSix);
        return sort(maxNoOfSixComparator);

    }

    public String loadBatingStrikeRateFour() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> maxNoOfFourComparator =Comparator.comparing(IPL -> IPL.noOfFour);
        return sort(maxNoOfFourComparator);
    }

    public String loadBestStrickRate() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> bestStrickRateComparator =Comparator.comparing(IPL -> IPL.highestStrike);
        return sort(bestStrickRateComparator);
    }

    public String loadHighestRun() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> highestRunComparator =Comparator.comparing(IPL -> IPL.runs);
        return sort(highestRunComparator);
    }

    public String loadBolingAverageOfPlayerIplWktsData() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> bolingAvgComparator =Comparator.comparing(IPL -> IPL. bowlerAverage);
        return sort(bolingAvgComparator);
    }

    public String loadBestStrikeRateOfPlayerFromIplWktsData() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> strikerRateComparator =Comparator.comparing(IPL -> IPL.strikeRate);
        return sort(strikerRateComparator);
    }

    public String loadBesteconomyRateOfPlayerFromIplWktsData() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> economyRateComparator =Comparator.comparing(IPL -> IPL.economicsRate);
        return sort(economyRateComparator);
    }

    public String loadBestStrikingRate4W5WOfPlayerFromIplWktsData() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> strikngRate4WComparator =Comparator.comparing(IPL -> IPL.fourWikets);
        return sort(strikngRate4WComparator);
    }

    public String loadHighestWiketsOfPlayerFromIplWktsData() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> strikngRate4WComparator =Comparator.comparing(IPL -> IPL.wikets);
        return sort(strikngRate4WComparator);
    }

    public String getBestSortedOnRunsAndWicketData() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> avgComparator =Comparator.comparing(IPL -> (IPL.batsmanAverage+IPL.bowlerAverage));
        return sort(avgComparator);
    }
    public String getAllRounderPlayerSortedOnRunsAndWicketData() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> avgComparator =Comparator.comparing(IPL -> IPL.batsmanAverage);
        return sort(avgComparator);
    }

}
