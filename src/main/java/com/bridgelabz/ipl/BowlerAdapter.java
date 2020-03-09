package com.bridgelabz.ipl;

import java.util.Map;

public class BowlerAdapter extends IPLAdapter {
    public Map<String, IPLCricketLeagueDTO> loadPlayerData(String... csvPath) {
        return super.loadPlayerData(BowlerCSV.class,csvPath[0]);
    }
}
