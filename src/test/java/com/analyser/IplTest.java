package com.analyser;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class IplTest {
    private static final String IPL_2019_MOST_RUN_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_2019_MOST_Wkts_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_BATSMAN_DATA_WRONG_DELIMITER = "./src/test/resources/IPL2019FactsheetMostRunsWithWrongDelimiter.csv";
    private static final String IPL_BATSMAN_DATA_WRONG_HEADER ="./src/test/resources/IPL2019FactsheetMostRunsWithWrongHeader.csv";
    private static final String IPL_BATSMAN_DATA_WRONG_TYPE ="./src/test/resources/IPL2019FactsheetMostRuns.txt";
    private static final String IPL_BATSMAN_DATA_EMPTY_FILE ="./src/test/resources/IPL2019FactsheetMostRunsEmptyFile.csv";


    @Test
    public void givenIPLData_WithRongPath_ShouldThrowCustomException() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.RUNS,WRONG_CSV_FILE_PATH);
        } catch (IplAnalyserException e) {
            Assert.assertEquals(IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM, e.type);
        }
    }
    @Test
    public void givenIPLDatawrongDelimeter_WhenAnalyse_ShouldThrowCustomException() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.RUNS,IPL_BATSMAN_DATA_WRONG_DELIMITER);
        } catch (IplAnalyserException e) {
           Assert.assertEquals(IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM, e.type);
        }
    }
    @Test
    public void givenIPLDatawrongHeader_WhenAnalyse_ShouldThrowCustomException() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.RUNS,IPL_BATSMAN_DATA_WRONG_HEADER );
        } catch (IplAnalyserException e) {
            Assert.assertEquals(IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM, e.type);
        }
    }
    @Test
    public void givenIPLDatawrongType_WhenAnalyse_ShouldThrowCustomException() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.RUNS,IPL_BATSMAN_DATA_WRONG_TYPE);
        } catch (IplAnalyserException e) {
            Assert.assertEquals(IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM, e.type);
        }
    }
    @Test
    public void givenIPLDataEmptyCsv_WhenAnalyse_ShouldThrowCustomException() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.RUNS,IPL_BATSMAN_DATA_EMPTY_FILE);
        } catch (IplAnalyserException e) {
            Assert.assertEquals(IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIplFactsSheetsMostRunsCSV_whenAnalyse_shouldReturnCorrectNoOfRecords()  {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            int noOfRecord = iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.RUNS, IPL_2019_MOST_RUN_CSV_FILE_PATH);
            Assert.assertEquals(100, noOfRecord);
        }catch( IplAnalyserException e) {}

    }

    @Test
    public void givenIplMostRunCSV_whenSortedOnBattingAverage_shouldReturnShortedResult() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.RUNS,IPL_2019_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.getSortedData(IplAnalyser.CompareType.BATSMAN_AVERAGE);
            IplMostRunsCSV[] IplDataCSV = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals("MS Dhoni", IplDataCSV[0].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIplMostRunCSV_whenSortedOnStrikeRate_shouldReturnShortedResult() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.RUNS,IPL_2019_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.getSortedData(IplAnalyser.CompareType.BATSMAN_STRIKE);
            IplMostRunsCSV[] IplDataCSV = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals("Ishant Sharma", IplDataCSV[0].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostRunCSV_whenSortedOnMaxSix_shouldReturnShortedResult() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.RUNS,IPL_2019_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.getSortedData(IplAnalyser.CompareType.SIX_AND_FOUR);
            IplMostRunsCSV[] iplBatsManData = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals("Andre Russell", iplBatsManData[0].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostRunCSV_whenSortedOnBatingStrikeRateFour_shouldReturnShortedResult() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.RUNS,IPL_2019_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.getSortedData(IplAnalyser.CompareType.BATSMAN_STRIKE_WITH_SIX_AND_FOUR);
            IplMostRunsCSV[] iplBatsManData = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals("Andre Russell", iplBatsManData[0].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIplMostRunCSV_whenSortedOnBestStrickRate_shouldReturnShortedResult() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.RUNS,IPL_2019_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.getSortedData(IplAnalyser.CompareType.BATSMAN_AVERAGE_WITH_STRIKE);
            IplMostRunsCSV[] iplBatsManData = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals("MS Dhoni", iplBatsManData[0].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostRunCSV_whenSortedOnHighestRun_shouldReturnShortedResult() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.RUNS,IPL_2019_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.getSortedData(IplAnalyser.CompareType.BATSMAN_RUNS_WITH_AVERAGE);
            IplMostRunsCSV[] iplBatsManData = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals("David Warner", iplBatsManData[0].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplFactsSheetsMostWktsCSV_whenAnalyse_shouldReturnCorrectNoOfRecords() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            int noOfRecord = iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.WICKET,IPL_2019_MOST_Wkts_CSV_FILE_PATH);
            Assert.assertEquals(99, noOfRecord);
        }catch( IplAnalyserException e) {}

    }

    @Test
    public void givenIplMostWktsCSV_whenSortedOnBolingAverage_shouldReturnShortedResult() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.WICKET,IPL_2019_MOST_Wkts_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.getSortedData(IplAnalyser.CompareType.BOWLER_AVERAGE);
            IplMostWktsCSV[] iplBatsManData = new Gson().fromJson( sortedResult , IplMostWktsCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham", iplBatsManData[0].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostWktsCSV_whenSortedStrikeRate_shouldReturnShortedResult() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.WICKET,IPL_2019_MOST_Wkts_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.getSortedData(IplAnalyser.CompareType.BOWLER_STRIKE);
            IplMostWktsCSV[] iplBatsManData = new Gson().fromJson( sortedResult , IplMostWktsCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham", iplBatsManData[0].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostWktsCSV_whenSortedBestEconomy_shouldReturnShortedResult() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.WICKET,IPL_2019_MOST_Wkts_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.getSortedData(IplAnalyser.CompareType.ECONOMY);
            IplMostWktsCSV[] iplBatsManData = new Gson().fromJson( sortedResult , IplMostWktsCSV[].class);
            Assert.assertEquals("Ben Cutting", iplBatsManData[0].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostWktsCSV_whenSortedOnBestStriking4W5W_shouldReturnShortedResult() {

        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.WICKET,IPL_2019_MOST_Wkts_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.getSortedData(IplAnalyser.CompareType.BOWLER_STRIKE_WITH_FOUR_AND_FIVE_WICKETS);
            IplMostWktsCSV[] iplBowlerData = new Gson().fromJson( sortedResult , IplMostWktsCSV[].class);
            Assert.assertEquals("Lasith Malinga", iplBowlerData[0].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenBothBatingAndBowlingCSV_whenAnalyse_shouldReturnCorrectNoOfRecords() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            int noOfRecord = iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.BATTING_BOWLING,IPL_2019_MOST_RUN_CSV_FILE_PATH,IPL_2019_MOST_Wkts_CSV_FILE_PATH);
            Assert.assertEquals(150, noOfRecord);
        }catch( IplAnalyserException e) {}

    }
    @Test
    public void givenBowlersAndBatsmanData_whenSortedAccordingToRunsAndWickets_shouldReturnSortedResults() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.BATTING_BOWLING,IPL_2019_MOST_RUN_CSV_FILE_PATH,IPL_2019_MOST_Wkts_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.getSortedData(IplAnalyser.CompareType.BATSMAN_AVERAGE_WITH_BOWLER_AVERAGE);
            IplRunsWktsDAO[] iplBowlerData = new Gson().fromJson(sortedResult,  IplRunsWktsDAO[].class);
            Assert.assertEquals("Krishnappa Gowtham", iplBowlerData[0].player);
        } catch (IplAnalyserException e) {}
    }

    @Test
    public void givenBowlersAndBatsmanData_whenSortedAccordingToRunsAndWickets_shouldReturnDataOf16thPlayer() {
        try {
            IplAnalyser  iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplFactsSheetData(IplAnalyser.IPL.BATTING_BOWLING,IPL_2019_MOST_RUN_CSV_FILE_PATH,IPL_2019_MOST_Wkts_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.getSortedData(IplAnalyser.CompareType.RUNS_WITH_WICKETS);
            IplRunsWktsDAO[] iplBowlerData = new Gson().fromJson(sortedResult, IplRunsWktsDAO[].class);
            Assert.assertEquals("David Warner", iplBowlerData[0].player);
        } catch (IplAnalyserException e) {}
    }

}
