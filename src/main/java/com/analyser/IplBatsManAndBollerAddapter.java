package com.analyser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IplBatsManAndBollerAddapter extends IplAddapter{
    List<IplRunsWktsDAO> batsmanData = new ArrayList<>();
    List<IplRunsWktsDAO> bowlersData = new ArrayList<>();
    List<IplRunsWktsDAO> BatsmanBowlersData = new ArrayList<>();
    @Override
    public List<IplRunsWktsDAO> loadIPLData(String... csvFilePath)  throws IplAnalyserException {
        batsmanData =super.loadIPLData(IplMostRunsCSV.class, csvFilePath[0]);
        bowlersData = super.loadIPLData(IplMostWktsCSV.class, csvFilePath[1]);
        BatsmanBowlersData= Stream.concat(batsmanData.stream(),bowlersData.stream()).collect(Collectors.toList());
        return BatsmanBowlersData;
    }
}
