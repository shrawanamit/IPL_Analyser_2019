package com.analyser;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;



public class IplAnalyser {


    List<IplRunsDAO> iplRunsList;

    public IplAnalyser() {
        this.iplRunsList = new ArrayList<>();
    }

    public int loadIplMostRunData(String csvFilePath) throws IplAnalyserException{
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<IplMostRunsCSV> csvFileIterator = csvBuilder.getCSVFileIterator(reader, IplMostRunsCSV.class);
            while (csvFileIterator.hasNext()) {
                this.iplRunsList.add(new IplRunsDAO(csvFileIterator.next()));
            }
            return this.iplRunsList.size();
        } catch (IOException | CSVBuilderException e) {
            throw new IplAnalyserException(e.getMessage(), IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
        }
    }
}
