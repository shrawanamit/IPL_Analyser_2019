package com.analyser;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IPlLoader {

    private List iplLoaderList=new ArrayList();

    public <E> List<IplRunsWktsDAO> loadIPLData(String csvFilePath, Class<E> IPLCSVClass) throws IplAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            if (IPLCSVClass.getName().equals("com.analysr.IplMostRunsCSV")) {
                Iterator<IplMostRunsCSV> csvFileIterator = csvBuilder.getCSVFileIterator(reader,IplMostRunsCSV.class);
                while (csvFileIterator.hasNext()) {
                    this.iplLoaderList.add(new IplRunsWktsDAO( csvFileIterator.next()));
                }
            } else if (IPLCSVClass.getName().equals("com.analyser.IplMostWktsCSV")) {
                Iterator<IplMostWktsCSV> csvFileIterator = csvBuilder.getCSVFileIterator(reader,IplMostWktsCSV.class);
                while (csvFileIterator.hasNext()) {
                    this.iplLoaderList.add(new IplRunsWktsDAO(csvFileIterator.next()));
                }
            }
            return iplLoaderList;
        } catch (IOException | CSVBuilderException | IplAnalyserException e) {
            throw new IplAnalyserException(e.getMessage(), IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
        }
    }
}
