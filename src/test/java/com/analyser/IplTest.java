package com.analyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IplTest {
    private static final String IPL_2019_MOST_RUN_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_2019_MOST_Wkts_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IPL2019FactsheetMostRuns.csv";
    @Test
    public void givenIplMostRun_whenSortedOnBatingAverage_shouldReturnShortedResult() throws IplAnalyserException {
        IplAnalyser iplAnalyser = new IplAnalyser();
        int noOfRecord = iplAnalyser.loadIplMostRunData(IPL_2019_MOST_RUN_CSV_FILE_PATH);
        Assert.assertEquals(101, noOfRecord);

    }

}
