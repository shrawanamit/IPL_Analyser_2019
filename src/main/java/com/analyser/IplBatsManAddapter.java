package com.analyser;
import java.util.Map;

public  class IplBatsManAddapter extends IplAddapter {
    @Override
    public Map<String,IplRunsWktsDAO> loadIPLData(String... csvFilePath)  throws IplAnalyserException {
        return super.loadIPLData(IplMostRunsCSV.class,csvFilePath[0]);
    }
}