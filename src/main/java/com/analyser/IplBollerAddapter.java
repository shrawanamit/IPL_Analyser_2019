package com.analyser;
import java.util.Map;

public class IplBollerAddapter extends IplAddapter{
    @Override
    public Map<String,IplRunsWktsDAO> loadIPLData(String... csvFilePath)  throws IplAnalyserException {
    return super.loadIPLData(IplMostWktsCSV.class, csvFilePath[0]);
    }
}
