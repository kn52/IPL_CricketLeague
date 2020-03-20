package com.bridgelabz.ipl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IPLCricketLeagueAnalyser {

    private IPLAdapter iplAdaptor;

    public void setIPLAdaptor(IPLAdapter iplAdapter) {
        this.iplAdaptor=iplAdapter;
    }

    public enum PlayerType {BATSMAN, BOWLER,BATSMAN_BOWLER}

    List<IPLCricketLeagueDTO> csvList = null;
    Map<String, IPLCricketLeagueDTO> playerMap = null;
    private PlayerType playerType;

    public IPLCricketLeagueAnalyser() {   }

    public IPLCricketLeagueAnalyser(PlayerType playerType) {
        this.playerType = playerType;
        new ComparatorSort();
    }

    public Map<String, IPLCricketLeagueDTO> loadData(PlayerType player, String... csvPath) {
        playerMap=new IPLAdapter().loadPlayerData(player, csvPath);
        return playerMap;
    }

    public String getSortByField(ComparatorSort.SortType field) {
        csvList=playerMap.values().stream().sorted(ComparatorSort.getComparator(field).reversed()).collect(Collectors.toList());
        return csvList.get(0).player;
    }
}
