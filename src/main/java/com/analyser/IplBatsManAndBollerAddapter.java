package com.analyser;
import java.util.*;

public class IplBatsManAndBollerAddapter extends IplAddapter{

    Map<String, IplRunsWktsDAO> batsmanData = new HashMap<>();
    Map<String, IplRunsWktsDAO> bowlersData = new HashMap<>();

    @Override
    public Map<String,IplRunsWktsDAO> loadIPLData(String... csvFilePath)  throws IplAnalyserException {
        batsmanData =super.loadIPLData(IplMostRunsCSV.class, csvFilePath[0]);
        bowlersData = super.loadIPLData(IplMostWktsCSV.class, csvFilePath[1]);
        bowlersData.values().stream()
                .filter(iplData -> batsmanData.get(iplData.player) != null)
                .forEach(iplData -> {
                    batsmanData.get(iplData.player).average = iplData.average;
                    batsmanData.get(iplData.player).wickets = iplData.wickets;
                });
        return batsmanData;
    }
}
