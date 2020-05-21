package com.analyser;
import com.censusanalyser.CensusAnalyser;
import com.censusanalyser.CensusAnalyserException;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class IplTest {
    private static final String IPL_2019_MOST_RUN_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_2019_MOST_Wkts_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IPL2019FactsheetMostRuns.csv";

    @Test
    public void givenIplFactsSheetsMostRunssCSV_whenAnalyse_shouldReturnCorrectNoOfRecords() throws IplAnalyserException {

        IplAnalyser iplAnalyser = new IplAnalyser();
        int noOfRecord = iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.RUNS,IPL_2019_MOST_RUN_CSV_FILE_PATH);
        Assert.assertEquals(101, noOfRecord);

    }
    @Test
    public void givenIplFactsSheetsMostWktsCSV_whenAnalyse_shouldReturnCorrectNoOfRecords() throws IplAnalyserException {

        IplAnalyser iplAnalyser = new IplAnalyser();
        int noOfRecord = iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.WICKET,IPL_2019_MOST_Wkts_CSV_FILE_PATH);
        Assert.assertEquals(99, noOfRecord);

    }
    @Test
    public void givenIPLData_WhenCorrect_butPathIncorrectShouldThrowCustomException() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(IplAnalyserException.class);
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.RUNS,WRONG_CSV_FILE_PATH);
        } catch (IplAnalyserException e) {
            Assert.assertEquals(IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM, e.type);
        }
    }
    @Test
    public void givenIplMostRunCSV_whenSortedOnBattingAverage_shouldReturnShortedResult() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.RUNS,IPL_2019_MOST_RUN_CSV_FILE_PATH);
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
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.RUNS,IPL_2019_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadSortedOnStrikeRate();
            IplMostRunsCSV[] IplDataCSV = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals(63.150001525878906, IplDataCSV[0].strikeRate,0.001);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostRunCSV_whenSortedOnMaxSix_shouldReturnShortedResult() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.RUNS,IPL_2019_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadMaxSixInIpl();
            IplMostRunsCSV[] iplBatsManData = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals("Andre Russell", iplBatsManData[100].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostRunCSV_whenSortedOnBatingStrikeRateFour_shouldReturnShortedResult() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.RUNS,IPL_2019_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadBatingStrikeRateFour();
            IplMostRunsCSV[] iplBatsManData = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals("Shikhar Dhawan", iplBatsManData[100].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIplMostRunCSV_whenSortedOnBestStrickRate_shouldReturnShortedResult() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.RUNS,IPL_2019_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadBestStrickRate();
            IplMostRunsCSV[] iplBatsManData = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals("Jonny Bairstow", iplBatsManData[100].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostRunCSV_whenSortedOnHighestRun_shouldReturnShortedResult() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.RUNS,IPL_2019_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadHighestRun();
            IplMostRunsCSV[] iplBatsManData = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals("David Warner", iplBatsManData[100].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostWktsCSV_whenSortedOnBolingAverage_shouldReturnShortedResult() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.WICKET,IPL_2019_MOST_Wkts_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadBolingAverageOfPlayerIplWktsData();
            IplMostRunsCSV[] iplBatsManData = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham", iplBatsManData[98].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostWktsCSV_whenSortedStrikeRate_shouldReturnShortedResult() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.WICKET,IPL_2019_MOST_Wkts_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadBestStrikeRateOfPlayerFromIplWktsData();
            IplMostRunsCSV[] iplBatsManData = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham", iplBatsManData[98].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostWktsCSV_whenSortedBestEconomy_shouldReturnShortedResult() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.WICKET,IPL_2019_MOST_Wkts_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadBesteconomyRateOfPlayerFromIplWktsData();
            IplMostRunsCSV[] iplBatsManData = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals("Ben Cutting", iplBatsManData[98].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostWktsCSV_whenSortedOnBestStriking4W5W_shouldReturnShortedResult() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.WICKET,IPL_2019_MOST_Wkts_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadBestStrikingRate4W5WOfPlayerFromIplWktsData();
            IplMostWktsCSV[] iplBowlerData = new Gson().fromJson( sortedResult , IplMostWktsCSV[].class);
            Assert.assertEquals("Lasith Malinga", iplBowlerData[98].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIplMostWktsCSV_whenSortedOnHighestWikets_shouldReturnShortedResult() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.WICKET,IPL_2019_MOST_Wkts_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadHighestWiketsOfPlayerFromIplWktsData();
            IplMostWktsCSV[] iplBowlerData = new Gson().fromJson( sortedResult , IplMostWktsCSV[].class);
            Assert.assertEquals("Imran Tahir", iplBowlerData[98].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIplMostRunCSV_whenSortedOnHighestRunAndHighestWkts_shouldReturnShortedResult() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.RUNS,IPL_2019_MOST_RUN_CSV_FILE_PATH);
            String sortedResultRun = iplAnalyser.loadBestRuns();
            IplMostRunsCSV[] iplBatsManData = new Gson().fromJson( sortedResultRun , IplMostRunsCSV[].class);
            String s = iplBatsManData[100].player;
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.WICKET,IPL_2019_MOST_Wkts_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadHighestWiketsOfPlayerFromIplWktsData();
            IplMostWktsCSV[] iplBatsManDataW = new Gson().fromJson( sortedResult , IplMostWktsCSV[].class);
            String s1=iplBatsManDataW[98].player;
            s=s.concat(s1);
            Assert.assertEquals("David Warner"+"Imran Tahir",s);

        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIplSheetCSV_whenSortedOnBestAvgAndWkts_shouldReturnShortedResult() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.RUNS,IPL_2019_MOST_RUN_CSV_FILE_PATH);
            String sortedResultRun = iplAnalyser.loadBestAvgAndWkts();
            IplMostRunsCSV[] iplBatsManData = new Gson().fromJson( sortedResultRun , IplMostRunsCSV[].class);
            String s = iplBatsManData[100].player;
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.WICKET,IPL_2019_MOST_Wkts_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadBestAvgWkts();
            IplMostWktsCSV[] iplBatsManDataW = new Gson().fromJson( sortedResult , IplMostWktsCSV[].class);
            String s1=iplBatsManDataW[98].player;
            s=s.concat(s1);
            Assert.assertEquals("MS Dhoni"+"Krishnappa Gowtham",s);

        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }
}
