package com.analyser;

public class IplAnalyserException extends Throwable{
    enum ExceptionType {
        IPL_FILE_PROBLEM,UNABLE_TO_PARSE,NO_IPL_DATA

    }ExceptionType type;

    public IplAnalyserException(String message, String name) {
        super(message);
        this.type=ExceptionType.valueOf(name);
    }
    public IplAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
