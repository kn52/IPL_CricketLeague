package com.brideglabz.ipl;

public class IPLCricketLeagueAnalyserException extends RuntimeException {

    public enum ExceptionType{
        FILE_PROBLEM
    }
    ExceptionType type;

    public IPLCricketLeagueAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
