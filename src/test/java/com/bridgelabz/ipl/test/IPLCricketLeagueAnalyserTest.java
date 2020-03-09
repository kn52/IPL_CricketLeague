package com.bridgelabz.ipl.test;

import com.bridgelabz.ipl.IPLCricketLeagueAnalyser;
import com.bridgelabz.ipl.IPLCricketLeagueAnalyserException;
import org.junit.Assert;
import org.junit.Test;

public class IPLCricketLeagueAnalyserTest {
    private static final String BATSMAN_CSV_FILE_PATH="./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String BOWLER_CSV_FILE_PATH="./src/test/resources/IPL2019FactsheetMostWkts.csv";

    IPLCricketLeagueAnalyser iplAnalyser;

    @Test
    public void givenBatsmanFilePath_WhenProper_ShouldReturn_TopBatsmanName() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BATSMAN);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BATSMAN,BATSMAN_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByAverage(IPLCricketLeagueAnalyser.SortField.AVERAGE);
            Assert.assertEquals("MS Dhoni",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBatsmanFilePath_WhenProper_ShouldReturn_TopBatsmanName_ByStrikeRate() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BATSMAN);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BATSMAN,BATSMAN_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByStrike(IPLCricketLeagueAnalyser.SortField.STRIKERATE);
            Assert.assertEquals("Ishant Sharma",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }
    @Test
    public void givenBatsmanFilePath_WhenProper_ShouldReturn_TopBatsmanName_ByDirectBoundary() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BATSMAN);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BATSMAN,BATSMAN_CSV_FILE_PATH);
            String name=iplAnalyser.getSortByBoundary(IPLCricketLeagueAnalyser.SortField.SIXES_FOURS);
            System.out.println("3->"+name);
            Assert.assertEquals("Andre Russell",name);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBatsmanFilePath_WhenProper_ShouldReturn_TopBatsmanName_ByStrikeRate_Six_Four() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BATSMAN);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BATSMAN,BATSMAN_CSV_FILE_PATH);
            String name=iplAnalyser.getSortByStrikeRate_Six_Four(IPLCricketLeagueAnalyser.SortField.SIXES_FOURS, IPLCricketLeagueAnalyser.SortField.STRIKERATE);
            System.out.println("4->"+name);
            Assert.assertEquals("Andre Russell",name);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace();  }
    }
    @Test
    public void givenBatsmanFilePath_WhenProper_ShouldReturn_TopBatsmanName_ByAverage_StrikeRate() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BATSMAN);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BATSMAN,BATSMAN_CSV_FILE_PATH);
            String name=iplAnalyser.getSortByAverage_StrikeRate(IPLCricketLeagueAnalyser.SortField.AVERAGE, IPLCricketLeagueAnalyser.SortField.STRIKERATE);
            System.out.println("5->"+name);
            Assert.assertEquals("MS Dhoni",name);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBatsmanFilePath_WhenProper_ShouldReturn_TopBatsmanName_ByRun_Average() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BATSMAN);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BATSMAN,BATSMAN_CSV_FILE_PATH);
            String name=iplAnalyser.getSortByRun_Average(IPLCricketLeagueAnalyser.SortField.AVERAGE, IPLCricketLeagueAnalyser.SortField.RUNS);
            System.out.println("6->"+name);
            Assert.assertEquals("MS Dhoni",name);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBowlerFilePath_WhenProper_ShouldReturn_TopBowlerName_ByAverage() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BOWLER);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BOWLER,BOWLER_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByAverage(IPLCricketLeagueAnalyser.SortField.AVERAGE);
            System.out.println(playerName);
            Assert.assertEquals("Krishnappa Gowtham",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBowlerFilePath_WhenProper_ShouldReturn_TopBowlerName_ByStrikeRate() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BOWLER);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BOWLER,BOWLER_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByStrike(IPLCricketLeagueAnalyser.SortField.STRIKERATE);
            System.out.println(playerName);
            Assert.assertEquals("Krishnappa Gowtham",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }
}

