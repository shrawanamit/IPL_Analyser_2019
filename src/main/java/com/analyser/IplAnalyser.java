package com.analyser;

import com.google.gson.Gson;
import java.util.*;
import java.util.stream.Collectors;

public class IplAnalyser {

    public enum IPL{RUNS,WICKET,BATTING_BOWLING}

    public enum CompareType { BATSMAN_AVERAGE,BATSMAN_STRIKE, RUNS, SIX_AND_FOUR, BATSMAN_AVERAGE_WITH_STRIKE,
       BATSMAN_STRIKE_WITH_SIX_AND_FOUR, BATSMAN_RUNS_WITH_AVERAGE, FOUR_AND_FIVE_WICKETS,
       BOWLER_AVERAGE, BOWLER_STRIKE, BOWLER_WICKETS,BOWLER_STRIKE_WITH_FOUR_AND_FIVE_WICKETS,
       ECONOMY,BOWLER_AVERAGE_WITH_STRIKE,BOWLER_WICKETS_WITH_AVERAGE,RUNS_WITH_WICKETS,
       BATSMAN_AVERAGE_WITH_BOWLER_AVERAGE}


    Map<String,IplRunsWktsDAO> iplRunsWktsDAOMap;
    public IplAnalyser() {
        this.iplRunsWktsDAOMap = new HashMap<>();
    }

    public int loadIplFactsSheetData(IPL ipl , String... csvFilePath) throws IplAnalyserException{
        iplRunsWktsDAOMap =IplAdapterFactory.getIplData(ipl,csvFilePath);
        return iplRunsWktsDAOMap.size();
    }

    public String getSortedData(CompareType compareType) throws IplAnalyserException {

        if(iplRunsWktsDAOMap == null || iplRunsWktsDAOMap.size() ==0 ) {
            throw new IplAnalyserException("no runs data",IplAnalyserException.ExceptionType.NO_IPL_DATA);
        }Comparator<IplRunsWktsDAO> iplComparator = new IPLComparator().getIPLDataComparator(compareType);
        List sortedAvgRunsData = iplRunsWktsDAOMap.values()
                                    .stream()
                                    .sorted(iplComparator.reversed())
                                    .collect(Collectors.toList());
        String sortedAverageRunsDataInJson = new Gson().toJson(sortedAvgRunsData);
        return sortedAverageRunsDataInJson;
    }


}
