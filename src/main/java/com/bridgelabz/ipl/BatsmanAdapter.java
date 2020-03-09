package com.bridgelabz.ipl;

import java.util.Map;

public class BatsmanAdapter extends IPLAdapter{
    public Map<String, IPLCricketLeagueDTO> loadPlayerData(String... csvPath) {
        return super.loadPlayerData(BatsmanCSV.class,csvPath[0]);
    }
}
