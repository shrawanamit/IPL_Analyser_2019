package com.analyser;

public class CSVBuilderException extends Exception {
    public enum ExceptionType {
        CENSUS_FILE_PROBLEM,UNABLE_TO_PARSE;

    }
   public ExceptionType type;

    public CSVBuilderException(String message, CSVBuilderException.ExceptionType type) {
        super(message);
        this.type = type;
    }
}
