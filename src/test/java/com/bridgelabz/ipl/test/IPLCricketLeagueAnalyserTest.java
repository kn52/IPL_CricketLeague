package com.bridgelabz.ipl.test;

import com.bridgelabz.ipl.ComparatorSort;
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
            String playerName=iplAnalyser.getSortByField(ComparatorSort.SortType.BT_AVERAGE);
            Assert.assertEquals("MS Dhoni",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBatsmanFilePath_WhenProper_ShouldReturn_TopBatsmanName_ByStrikeRate() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BATSMAN);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BATSMAN,BATSMAN_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByField(ComparatorSort.SortType.BT_STRIKE_RATE);
            Assert.assertEquals("Ishant Sharma",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }
    @Test
    public void givenBatsmanFilePath_WhenProper_ShouldReturn_TopBatsmanName_ByDirectBoundary() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BATSMAN);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BATSMAN,BATSMAN_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByField(ComparatorSort.SortType.BT_SIX_FOUR);
            Assert.assertEquals("Andre Russell",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBatsmanFilePath_WhenProper_ShouldReturn_TopBatsmanName_ByStrikeRate_Six_Four() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BATSMAN);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BATSMAN,BATSMAN_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByField(ComparatorSort.SortType.BT_STRIKE_SIX_FOUR);
            Assert.assertEquals("Andre Russell",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace();  }
    }
    @Test
    public void givenBatsmanFilePath_WhenProper_ShouldReturn_TopBatsmanName_ByAverage_StrikeRate() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BATSMAN);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BATSMAN,BATSMAN_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByField(ComparatorSort.SortType.BT_AVERAGE_STRIKE_RATE);
            Assert.assertEquals("MS Dhoni",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBatsmanFilePath_WhenProper_ShouldReturn_TopBatsmanName_ByRun_Average() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BATSMAN);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BATSMAN,BATSMAN_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByField(ComparatorSort.SortType.BT_RUNS_AVERAGE);
            Assert.assertEquals("MS Dhoni",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBowlerFilePath_WhenProper_ShouldReturn_TopBowlerName_ByAverage() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BOWLER);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BOWLER,BOWLER_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByField(ComparatorSort.SortType.BW_AVERAGE);
            Assert.assertEquals("Krishnappa Gowtham",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBowlerFilePath_WhenProper_ShouldReturn_TopBowlerName_ByStrikeRate() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BOWLER);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BOWLER,BOWLER_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByField(ComparatorSort.SortType.BW_STRIKE_RATE);
            Assert.assertEquals("Krishnappa Gowtham",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBowlerFilePath_WhenProper_ShouldReturn_TopBowlerName_ByEconomy() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BOWLER);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BOWLER,BOWLER_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByField(ComparatorSort.SortType.BW_ECONOMY);
            Assert.assertEquals("Ben Cutting",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBowlerFilePath_WhenProper_ShouldReturn_TopBowlerName_ByStrike_FourFiveWickets() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BOWLER);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BOWLER,BOWLER_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByField(ComparatorSort.SortType.BW_STRIKE_FOURW_FIVEW);
            Assert.assertEquals("Lasith Malinga",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBowlerFilePath_WhenProper_ShouldReturn_TopBowlerName_ByAverage_StrikeRate() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BOWLER);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BOWLER,BOWLER_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByField(ComparatorSort.SortType.BW_AVRAGE_STRIKE);
            Assert.assertEquals("Krishnappa Gowtham",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBowlerFilePath_WhenProper_ShouldReturn_TopBowlerName_ByWickets_Average() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BOWLER);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BOWLER,BOWLER_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByField(ComparatorSort.SortType.BW_WICKETS_AVRAGE);
            Assert.assertEquals("Imran Tahir",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBatsmanBowlerFilePath_WhenProper_ShouldReturn_TopBatsmanBowlerName_ByBattingBowlingAverage() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BATSMAN_BOWLER);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BATSMAN,BATSMAN_CSV_FILE_PATH,BOWLER_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByField(ComparatorSort.SortType.BT_BW_AVERAGE);
            Assert.assertEquals("Krishnappa Gowtham",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }

    @Test
    public void givenBatsmanBowlerFilePath_WhenProper_ShouldReturn_TopBatsmanBowlerName_ByRuns_Wickets() {
        try {
            iplAnalyser=new IPLCricketLeagueAnalyser(IPLCricketLeagueAnalyser.PlayerType.BATSMAN_BOWLER);
            iplAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BATSMAN,BATSMAN_CSV_FILE_PATH,BOWLER_CSV_FILE_PATH);
            String playerName=iplAnalyser.getSortByField(ComparatorSort.SortType.BT_BW_RUNS_WICKETS);
            Assert.assertEquals("Andre Russell",playerName);
        } catch (IPLCricketLeagueAnalyserException e) { e.printStackTrace(); }
    }
}

