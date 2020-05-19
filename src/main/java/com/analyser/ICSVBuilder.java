package com.analyser;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public interface ICSVBuilder<E> {


   Iterator<E> getCSVFileIterator(Reader reader, Class csvClass) throws IplAnalyserException, CSVBuilderException;
    List<E> getCSVFileList(Reader reader, Class csvClass) throws IplAnalyserException, CSVBuilderException;

}
