package com.analyser;

import java.util.Map;

public class IplAdapterFactory {
    public static Map<String,IplRunsWktsDAO> getIplData(IplAnalyser.IPL ipl, String... csvFilePath) throws IplAnalyserException {

        if (ipl.equals(IplAnalyser.IPL.RUNS)) {
            return new IplBatsManAddapter().loadIPLData( csvFilePath);
        }if (ipl.equals(IplAnalyser.IPL.WICKET)) {
            return new IplBollerAddapter().loadIPLData( csvFilePath);
        }
        return new IplBatsManAndBollerAddapter().loadIPLData(csvFilePath);
    }
}
