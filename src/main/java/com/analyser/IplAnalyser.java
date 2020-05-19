package com.analyser;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class IplAnalyser {

    List<IplRunsWktsDAO> iplRunsList;
    public IplAnalyser() {
        this.iplRunsList = new ArrayList<>();
    }

    public int loadIplFactsSheetMostRunsData(String csvFilePath) throws IplAnalyserException{

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<IplMostRunsCSV> csvFileIterator = csvBuilder.getCSVFileIterator(reader, IplMostRunsCSV.class);
            while (csvFileIterator.hasNext()) {
                this.iplRunsList.add(new IplRunsWktsDAO(csvFileIterator.next()));
            }
            return this.iplRunsList.size();
        } catch (IOException | CSVBuilderException e) {
            throw new IplAnalyserException(e.getMessage(), IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
        }
    }


    public int loadIplFactsSheetMostWiktsData(String csvFilePath) throws IplAnalyserException{

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<IplMostWktsCSV> csvFileIterator = csvBuilder.getCSVFileIterator(reader, IplMostWktsCSV.class);
            while (csvFileIterator.hasNext()) {
                this.iplRunsList.add(new IplRunsWktsDAO(csvFileIterator.next()));
            }
            return this.iplRunsList.size();
        } catch (IOException | CSVBuilderException e) {
            throw new IplAnalyserException(e.getMessage(), IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
        }
    }

    public String loadSortedOnBattingAverage() throws IplAnalyserException {

        Comparator<IplRunsWktsDAO> averageComparator =Comparator.comparing(census -> census.average);
        return sort(averageComparator);
    }

    private String sort(Comparator<IplRunsWktsDAO> averageComparator) throws IplAnalyserException {

        if(iplRunsList == null || iplRunsList.size() ==0 ) {
            throw new IplAnalyserException("no runs data",IplAnalyserException.ExceptionType.NO_IPL_DATA);
        }List sortedAvgRunsData =iplRunsList
                                    .stream()
                                    .sorted(averageComparator)
                                    .collect(Collectors.toList());
            String sortedAverageRunsDataInJson = new Gson().toJson(sortedAvgRunsData);
            return sortedAverageRunsDataInJson;
    }

    public String loadSortedOnStrikeRate() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> strikeRateComparator =Comparator.comparing(census -> census.strikeRate);
        return sort(strikeRateComparator);
    }

    public String loadMaxSixInIpl() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> maxNoOfSixComparator =Comparator.comparing(census -> census.noOfSix);
        return sort(maxNoOfSixComparator);

    }

    public String loadBatingStrikeRateFour() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> maxNoOfFourComparator =Comparator.comparing(census -> census.noOfFour);
        return sort(maxNoOfFourComparator);
    }

    public String loadBestStrickRate() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> bestStrickRateComparator =Comparator.comparing(census -> census.highestStrike);
        return sort(bestStrickRateComparator);
    }

    public String loadHighestRun() throws IplAnalyserException {
        Comparator<IplRunsWktsDAO> highestRunComparator =Comparator.comparing(census -> census.runs);
        return sort(highestRunComparator);
    }
}
