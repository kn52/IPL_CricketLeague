package com.bridgelabz.ipl;

import java.util.Map;

public class BatsmanBowlerAdapter extends IPLAdapter{
    public Map<String, IPLCricketLeagueDTO> loadPlayerData(String ...csvPath) {
        Map<String,IPLCricketLeagueDTO> returnMap1=null;
        Map<String,IPLCricketLeagueDTO> returnMap2=null;
        returnMap1=super.loadPlayerData(BatsmanCSV.class,csvPath[0]);
        returnMap2=super.loadPlayerData(BowlerCSV.class,csvPath[1]);
        returnMap1.putAll(returnMap2);
        return returnMap1;
    }
}
