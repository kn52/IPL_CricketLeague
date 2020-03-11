package com.bridgelabz.ipl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IPLCricketLeagueAnalyser {

    public int getCount() {

        System.out.println(playerMap);
        return playerMap.size();

    }

    public enum PlayerType {BATSMAN, BOWLER,BATSMAN_BOWLER}

    public enum SortField {
        AVERAGE, STRIKERATE, SIXES_FOURS, RUNS, ECONOMY, FOURW_FIVEW, WICKETS ,BTAVERAGE,BLAVERAGE;
    }

    ;
    Map<SortField, Comparator<IPLCricketLeagueDTO>> sortFieldMap = null;
    List<IPLCricketLeagueDTO> csvList = null;
    Map<String, IPLCricketLeagueDTO> playerMap = null;
    private PlayerType playerType;

    public IPLCricketLeagueAnalyser() {

    }

    public String getSortByAverage(SortField field) {
        csvList = playerMap.values().stream().sorted(this.sortFieldMap.get(field)).collect(Collectors.toList());
        return csvList.get(0).player;
    }

    public String getSortByStrike(SortField field) {
        csvList = playerMap.values().stream().sorted(this.sortFieldMap.get(field)).collect(Collectors.toList());
        return csvList.get(0).player;
    }

    public String getSortByBoundary(SortField field) {
        csvList = playerMap.values().stream().sorted(this.sortFieldMap.get(field)).collect(Collectors.toList());
        return csvList.get(0).player;
    }

    public String getSortByStrikeRate_Six_Four(SortField field1, SortField field2) {
        Comparator<IPLCricketLeagueDTO> comparator = this.sortFieldMap.get(field1);
        comparator.thenComparing(this.sortFieldMap.get(field2));
        csvList = playerMap.values().stream().sorted(comparator).collect(Collectors.toList());
        return csvList.get(0).player;
    }

    public String getSortByAverage_StrikeRate(SortField field1, SortField field2) {
        Comparator<IPLCricketLeagueDTO> comparator = this.sortFieldMap.get(field1);
        comparator.thenComparing(this.sortFieldMap.get(field2));
        csvList = playerMap.values().stream().sorted(comparator).collect(Collectors.toList());
        return csvList.get(0).player;
    }

    public String getSortByRun_Average(SortField field1, SortField field2) {
        Comparator<IPLCricketLeagueDTO> comparator = this.sortFieldMap.get(field1);
        comparator.thenComparing(this.sortFieldMap.get(field2));
        csvList = playerMap.values().stream().sorted(comparator).collect(Collectors.toList());
        return csvList.get(0).player;
    }

    public String getSortByEconomy(SortField field) {
        csvList = playerMap.values().stream().sorted(this.sortFieldMap.get(field)).collect(Collectors.toList());
        return csvList.get(0).player;
    }

    public String getSortByFourFiveWickets(SortField field1, SortField field2) {
        Comparator<IPLCricketLeagueDTO> comparator = this.sortFieldMap.get(field1);
        comparator.thenComparing(this.sortFieldMap.get(field2));
        csvList = playerMap.values().stream().sorted(comparator).collect(Collectors.toList());
        return csvList.get(0).player;
    }

    public String getSortByWickets_Average(SortField field1, SortField field2) {
        Comparator<IPLCricketLeagueDTO> comparator = this.sortFieldMap.get(field1);
        comparator.thenComparing(this.sortFieldMap.get(field2));
        csvList = playerMap.values().stream().sorted(comparator).collect(Collectors.toList());
        return csvList.get(0).player;
    }

    public String getSortByBattingBowlingAverage(SortField field1,SortField field2) {
        Comparator<IPLCricketLeagueDTO> comparator = this.sortFieldMap.get(field1);
        comparator.thenComparing(this.sortFieldMap.get(field2));
        csvList = playerMap.values().stream().sorted(comparator).collect(Collectors.toList());
        return csvList.get(0).player;
    }

    public String getSortByRuns_Wickets(SortField field1, SortField field2) {
        Comparator<IPLCricketLeagueDTO> comparator = this.sortFieldMap.get(field1);
        comparator.thenComparing(this.sortFieldMap.get(field2));
        csvList = playerMap.values().stream().sorted(comparator).collect(Collectors.toList());
        return csvList.get(0).player;
    }

    public IPLCricketLeagueAnalyser(PlayerType playerType) {
        this.playerType = playerType;
        sortFieldMap = new HashMap<>();
        sortFieldMap.put(SortField.AVERAGE, Comparator.comparing(x -> x.average, Comparator.reverseOrder()));
        sortFieldMap.put(SortField.STRIKERATE, Comparator.comparing(x -> x.strikeRate, Comparator.reverseOrder()));
        sortFieldMap.put(SortField.SIXES_FOURS, new ComparatorSort().reversed());
        sortFieldMap.put(SortField.RUNS, Comparator.comparing(x -> x.runs, Comparator.reverseOrder()));
        sortFieldMap.put(SortField.ECONOMY, Comparator.comparing(x -> x.economy, Comparator.reverseOrder()));
        sortFieldMap.put(SortField.FOURW_FIVEW, Comparator.comparing(x -> x.fourW + x.fiveW, Comparator.reverseOrder()));
        sortFieldMap.put(SortField.WICKETS, Comparator.comparing(x -> x.wickets, Comparator.reverseOrder()));
        sortFieldMap.put(SortField.BTAVERAGE, Comparator.comparing(x->x.btaverage));
        sortFieldMap.put(SortField.BLAVERAGE, Comparator.comparing(x->x.blaverage));
    }

    public void loadData(PlayerType player, String... csvPath) {
        playerMap = IPLAdapterFactory.getData(player, csvPath);
    }
}
