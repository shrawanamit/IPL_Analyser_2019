package com.analyser;
import java.util.List;

public class IplBatsManAddapter extends IplAddapter {
    @Override
    public List<IplRunsWktsDAO> loadIPLData(String csvFilePath)  throws IplAnalyserException {
        return super.loadIPLData(IplMostRunsCSV.class,csvFilePath);
    }
}
