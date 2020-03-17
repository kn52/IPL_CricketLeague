package com.bridgelabz.ipl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IPLCricketLeagueAnalyser {
    public enum PlayerType {BATSMAN, BOWLER,BATSMAN_BOWLER}

    List<IPLCricketLeagueDTO> csvList = null;
    Map<String, IPLCricketLeagueDTO> playerMap = null;
    private PlayerType playerType;

    public IPLCricketLeagueAnalyser(PlayerType playerType) {
        this.playerType = playerType;
        new ComparatorSort();
    }

    public void loadData(PlayerType player, String... csvPath) {
        playerMap =new IPLAdapter().loadPlayerData(player, csvPath);
    }

    public String getSortByField(ComparatorSort.SortType field) {
        csvList=playerMap.values().stream().sorted(ComparatorSort.getComparator(field).reversed()).collect(Collectors.toList());
        return csvList.get(0).player;
    }
}
