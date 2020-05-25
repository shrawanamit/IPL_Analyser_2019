package com.analyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.stream.StreamSupport;


public abstract  class IplAddapter {
    Map<String,IplRunsWktsDAO> iplLoaderData = new HashMap<>();
    public abstract Map<String,IplRunsWktsDAO> loadIPLData(String... csvFilePath) throws IplAnalyserException ;

    public   <E> Map<String,IplRunsWktsDAO> loadIPLData( Class<E> IPLCSVClass,String csvFilePath) throws IplAnalyserException {

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<E> csvFileIterator = csvBuilder.getCSVFileIterator(reader, IPLCSVClass);
            Iterable<E> csvIterable = () -> csvFileIterator;
            if (IPLCSVClass.getName().equals("com.analyser.IplMostRunsCSV")) {
                StreamSupport.stream(csvIterable.spliterator(), false)
                             .map(IplMostRunsCSV.class::cast)
                             .forEach(iplDataCsv -> iplLoaderData.put(iplDataCsv.player, new IplRunsWktsDAO(iplDataCsv)));
            } else if (IPLCSVClass.getName().equals("com.analyser.IplMostWktsCSV")) {
                StreamSupport.stream(csvIterable.spliterator(), false)
                             .map(IplMostWktsCSV.class::cast)
                             .forEach(iplDataCsv -> iplLoaderData.put(iplDataCsv.player, new IplRunsWktsDAO(iplDataCsv)));
            }
            return iplLoaderData;
        } catch (IOException | CSVBuilderException e) {
            throw new IplAnalyserException(e.getMessage(), IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
        }
    }
}
