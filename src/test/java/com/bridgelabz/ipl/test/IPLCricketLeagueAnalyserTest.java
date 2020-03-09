package com.bridgelabz.ipl.test;

import com.brideglabz.ipl.IPLCricketLeagueAnalyser;
import com.brideglabz.ipl.IPLCricketLeagueAnalyserException;
import org.junit.Assert;
import org.junit.Test;

public class IPLCricketLeagueAnalyserTest {
    private static final String BATSMAN_CSV_FILE_PATH="./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String BOWLER_CSV_FILE_PATH="./src/test/resources/IPL2019FactsheetMostRuns.csv";

    IPLCricketLeagueAnalyser iplAnalyser;

    @Test
    public void givenBatsmanFilePath_WhenProper_ShouldReturn_TopBatsmanName() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser();
            iplAnalyser.loadData(BATSMAN_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByAverage();
            Assert.assertEquals("MS Dhoni",playerName);
        } catch (IPLCricketLeagueAnalyserException e) {
        }

    }
}

