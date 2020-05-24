package com.analyser;

import java.util.List;

public class IplBollerAddapter extends IplAddapter{
    @Override
    public List<IplRunsWktsDAO> loadIPLData(String... csvFilePath)  throws IplAnalyserException {
    return super.loadIPLData(IplMostWktsCSV.class, csvFilePath[0]);
    }

}
