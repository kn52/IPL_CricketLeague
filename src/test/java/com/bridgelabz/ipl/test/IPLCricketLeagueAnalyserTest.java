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
            Assert.assertEquals("Andre Russell",name);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBatsmanFilePath_WhenProper_ShouldReturn_TopBatsmanName_ByStrikeRate_Six_Four() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BATSMAN);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BATSMAN,BATSMAN_CSV_FILE_PATH);
            String name=iplAnalyser.getSortByStrikeRate_Six_Four(IPLCricketLeagueAnalyser.SortField.SIXES_FOURS, IPLCricketLeagueAnalyser.SortField.STRIKERATE);
            Assert.assertEquals("Andre Russell",name);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace();  }
    }
    @Test
    public void givenBatsmanFilePath_WhenProper_ShouldReturn_TopBatsmanName_ByAverage_StrikeRate() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BATSMAN);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BATSMAN,BATSMAN_CSV_FILE_PATH);
            String name=iplAnalyser.getSortByAverage_StrikeRate(IPLCricketLeagueAnalyser.SortField.AVERAGE, IPLCricketLeagueAnalyser.SortField.STRIKERATE);
            Assert.assertEquals("MS Dhoni",name);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBatsmanFilePath_WhenProper_ShouldReturn_TopBatsmanName_ByRun_Average() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BATSMAN);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BATSMAN,BATSMAN_CSV_FILE_PATH);
            String name=iplAnalyser.getSortByRun_Average(IPLCricketLeagueAnalyser.SortField.AVERAGE, IPLCricketLeagueAnalyser.SortField.RUNS);
            Assert.assertEquals("MS Dhoni",name);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBowlerFilePath_WhenProper_ShouldReturn_TopBowlerName_ByAverage() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BOWLER);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BOWLER,BOWLER_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByAverage(IPLCricketLeagueAnalyser.SortField.AVERAGE);
            Assert.assertEquals("Krishnappa Gowtham",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBowlerFilePath_WhenProper_ShouldReturn_TopBowlerName_ByStrikeRate() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BOWLER);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BOWLER,BOWLER_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByStrike(IPLCricketLeagueAnalyser.SortField.STRIKERATE);
            Assert.assertEquals("Krishnappa Gowtham",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBowlerFilePath_WhenProper_ShouldReturn_TopBowlerName_ByEconomy() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BOWLER);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BOWLER,BOWLER_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByEconomy(IPLCricketLeagueAnalyser.SortField.ECONOMY);
            Assert.assertEquals("Ben Cutting",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBowlerFilePath_WhenProper_ShouldReturn_TopBowlerName_ByFourFiveWickets() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BOWLER);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BOWLER,BOWLER_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByFourFiveWickets(IPLCricketLeagueAnalyser.SortField.FOURW_FIVEW, IPLCricketLeagueAnalyser.SortField.STRIKERATE);
            Assert.assertEquals("Lasith Malinga",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBowlerFilePath_WhenProper_ShouldReturn_TopBowlerName_ByAverage_StrikeRate() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BOWLER);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BOWLER,BOWLER_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByAverage_StrikeRate(IPLCricketLeagueAnalyser.SortField.AVERAGE, IPLCricketLeagueAnalyser.SortField.STRIKERATE);
            Assert.assertEquals("Krishnappa Gowtham",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBowlerFilePath_WhenProper_ShouldReturn_TopBowlerName_ByWickets_Average() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BOWLER);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BOWLER,BOWLER_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByWickets_Average(IPLCricketLeagueAnalyser.SortField.WICKETS,IPLCricketLeagueAnalyser.SortField.AVERAGE);
            Assert.assertEquals("Imran Tahir",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBatsmanBowlerFilePath_WhenProper_ShouldReturn_TopBatsmanBowlerName_ByBattingBowlingAverage() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BATSMAN_BOWLER);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BATSMAN_BOWLER,BATSMAN_CSV_FILE_PATH,BOWLER_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByBattingBowlingAverage(IPLCricketLeagueAnalyser.SortField.BTAVERAGE,IPLCricketLeagueAnalyser.SortField.BLAVERAGE);
            Assert.assertEquals("Marcus Stoinis",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBatsmanBowlerFilePath_WhenProper_ShouldReturn_TopBatsmanBowlerName_ByRuns_Wickets() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BATSMAN_BOWLER);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BATSMAN_BOWLER,BATSMAN_CSV_FILE_PATH,BOWLER_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByRuns_Wickets(IPLCricketLeagueAnalyser.SortField.WICKETS,IPLCricketLeagueAnalyser.SortField.RUNS);
            Assert.assertEquals("Imran Tahir",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }
}

