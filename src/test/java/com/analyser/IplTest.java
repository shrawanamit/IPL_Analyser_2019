package com.analyser;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;


public class IplTest {
    private static final String IPL_2019_MOST_RUN_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_2019_MOST_Wkts_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IPL2019FactsheetMostRuns.csv";
    @Test
    public void givenIplMostRunCSV_whenSortedOnBatingAverage_shouldReturnShortedResult() throws IplAnalyserException {
        IplAnalyser iplAnalyser = new IplAnalyser();
        int noOfRecord = iplAnalyser.loadIplMostRunData(IPL_2019_MOST_RUN_CSV_FILE_PATH);
        Assert.assertEquals(101, noOfRecord);

    }
    @Test
    public void givenIplMostRunCSV_whenSortedOnBattingAverage_shouldReturnShortedResult() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplMostRunData(IPL_2019_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadSortedOnBattingAverage();
            IplMostRunsCSV[] IplDataCSV = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals(0.0, IplDataCSV[0].average,0.001);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIplMostRunCSV_whenSortedOnStrikeRate_shouldReturnShortedResult() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplMostRunData(IPL_2019_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadSortedOnStrikeRate();
            IplMostRunsCSV[] IplDataCSV = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals(4.0, IplDataCSV[0].average,0.001);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

}
