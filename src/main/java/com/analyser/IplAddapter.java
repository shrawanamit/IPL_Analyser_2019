package com.analyser;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract  class IplAddapter {
    private  List iplLoaderData = new ArrayList();

    abstract List<IplRunsWktsDAO> loadIPLData(String csvFilePath) throws IplAnalyserException ;

    public   <E> List<IplRunsWktsDAO> loadIPLData( Class<E> IPLCSVClass,String csvFilePath) throws IplAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            if (IPLCSVClass.getName().equals("com.analyser.IplMostRunsCSV")) {
                Iterator<IplMostRunsCSV> csvFileIterator = csvBuilder.getCSVFileIterator(reader,IplMostRunsCSV.class);
                while (csvFileIterator.hasNext()) {
                    this.iplLoaderData.add(new IplRunsWktsDAO( csvFileIterator.next()));
                }
            } else if (IPLCSVClass.getName().equals("com.analyser.IplMostWktsCSV")) {
                Iterator<IplMostWktsCSV> csvFileIterator = csvBuilder.getCSVFileIterator(reader,IplMostWktsCSV.class);
                while (csvFileIterator.hasNext()) {
                    this.iplLoaderData.add(new IplRunsWktsDAO(csvFileIterator.next()));
                }
            }
            return iplLoaderData;
        } catch (IOException | CSVBuilderException | IplAnalyserException e) {
            throw new IplAnalyserException(e.getMessage(), IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
        }
    }
}
