package com.bridgelabz.ipl;

import java.util.Map;

public class IPLAdapterFactory {
    public static Map<String,IPLCricketLeagueDTO> getData(IPLCricketLeagueAnalyser.PlayerType playerType, String... csvPath){
        if(playerType.equals(IPLCricketLeagueAnalyser.PlayerType.BATSMAN_BOWLER))
            return new BatsmanBowlerAdapter().loadPlayerData(csvPath);
        else if(playerType.equals(IPLCricketLeagueAnalyser.PlayerType.BATSMAN))
            return new BatsmanAdapter().loadPlayerData(csvPath);
        else if(playerType.equals(IPLCricketLeagueAnalyser.PlayerType.BOWLER))
            return new BowlerAdapter().loadPlayerData(csvPath);
        else
            throw new IPLCricketLeagueAnalyserException("INCORRECT_PLAYER", IPLCricketLeagueAnalyserException.ExceptionType.NO_SUCH_PlAYER);
    }
}
