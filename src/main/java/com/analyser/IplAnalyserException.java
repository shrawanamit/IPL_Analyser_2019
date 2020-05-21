package com.analyser;

public class IplAnalyserException extends Throwable{
    enum ExceptionType {
        IPL_FILE_PROBLEM,NO_IPL_DATA,INVALID_INPUT;

    }ExceptionType type;

    public IplAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
