package com.analyser;

import java.util.List;

public class IplAdapterFactory {
    public static List<IplRunsWktsDAO> getIplData(IplAnalyser.IPL ipl, String csvFilePath) throws IplAnalyserException {

        if (ipl.equals(IplAnalyser.IPL.RUNS)) {
            return new IplBatsManAddapter().loadIPLData( csvFilePath);
        }if (ipl.equals(IplAnalyser.IPL.WICKET)) {
            return new IplBollerAddapter().loadIPLData( csvFilePath);
        }
        throw new IplAnalyserException("INVALID INPUT",IplAnalyserException.ExceptionType.INVALID_INPUT);
    }
}
