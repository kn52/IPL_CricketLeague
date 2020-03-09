package com.bridgelabz.ipl.test;

import com.bridgelabz.ipl.IPLCricketLeagueAnalyser;
import com.bridgelabz.ipl.IPLCricketLeagueAnalyserException;
import org.junit.Assert;
import org.junit.Test;

public class IPLCricketLeagueAnalyserTest {
    private static final String BATSMAN_CSV_FILE_PATH="./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String BOWLER_CSV_FILE_PATH="./src/test/resources/IPL2019FactsheetMostRuns.csv";

    IPLCricketLeagueAnalyser iplAnalyser;

    @Test
    public void givenBatsmanFilePath_WhenProper_ShouldReturn_TopBatsmanName() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BATSMAN);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BATSMAN,BATSMAN_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByAverage(IPLCricketLeagueAnalyser.SortField.AVERAGE);
            Assert.assertEquals("MS Dhoni",playerName);
        } catch (IPLCricketLeagueAnalyserException e) {
        }
    }

    @Test
    public void givenBatsmanFilePath_WhenProper_ShouldReturn_TopBatsmanName_ByStrikeRate() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BATSMAN);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BATSMAN,BATSMAN_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByStrike(IPLCricketLeagueAnalyser.SortField.STRIKERATE);
            Assert.assertEquals("Ishant Sharma",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { }
    }
    @Test
    public void givenBatsmanFilePath_WhenProper_ShouldReturn_TopBatsmanName_ByDirectBoundary() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BATSMAN);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BATSMAN,BATSMAN_CSV_FILE_PATH);
            String name=iplAnalyser.getSortByBoundary(IPLCricketLeagueAnalyser.SortField.SIXES_FOURS);
            System.out.println("3->"+name);
            Assert.assertEquals("Andre Russell",name);
        } catch (IPLCricketLeagueAnalyserException e) { }
    }
}

