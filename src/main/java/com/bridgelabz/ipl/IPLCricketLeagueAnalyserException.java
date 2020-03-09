package com.bridgelabz.ipl;

public class IPLCricketLeagueAnalyserException extends RuntimeException {

    public IPLCricketLeagueAnalyserException(String incorrect, String message) {
        super(message);
    }

    public enum ExceptionType{
        FILE_PROBLEM,NO_SUCH_PlAYER
    }
    ExceptionType type;

    public IPLCricketLeagueAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
