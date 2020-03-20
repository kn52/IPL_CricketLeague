package com.bridgelabz.ipl.test;

import com.bridgelabz.ipl.IPLAdapter;
import com.bridgelabz.ipl.IPLCricketLeagueAnalyser;
import com.bridgelabz.ipl.IPLCricketLeagueDTO;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPLCricketLeagureMockito {

    @Mock
    IPLAdapter iplAdapter;

    @Rule
    public MockitoRule mockitoRule =MockitoJUnit.rule();

    private static final String BATSMAN_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String BOWLER_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";
    public Map<String, IPLCricketLeagueDTO> batsmanList;
    public Map<String, IPLCricketLeagueDTO> bowlerList;

    @Before
    public void setUp() throws Exception {
        this.iplAdapter=mock(IPLAdapter.class);
        this.batsmanList=new HashMap();
        this.bowlerList=new HashedMap();
        this.batsmanList.put("A", new IPLCricketLeagueDTO("V", 350, 68.2, 40, 6, 0));
        this.batsmanList.put("B", new IPLCricketLeagueDTO("P", 450, 78.2, 30, 8, 1));
        this.bowlerList.put("A", new IPLCricketLeagueDTO("K", 375, 66.2, 33, 5, 5));
        this.bowlerList.put("B", new IPLCricketLeagueDTO("A", 250, 60.2, 16, 6, 10));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whengivenBatsmanPath_ShouldReturn_BatsmanPlayerMap() {
        IPLCricketLeagueAnalyser iplCricketLeagueAnalyser=new IPLCricketLeagueAnalyser();
        Map<String,IPLCricketLeagueDTO> iplCricketLeagueDTOMap=new HashMap();
        when(iplAdapter.loadPlayerData(IPLCricketLeagueAnalyser.PlayerType.BATSMAN, BATSMAN_CSV_FILE_PATH)).thenReturn(batsmanList);
        iplCricketLeagueAnalyser.setIPLAdaptor(iplAdapter);
        iplCricketLeagueDTOMap=iplCricketLeagueAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BATSMAN, BATSMAN_CSV_FILE_PATH);
        System.out.println(iplCricketLeagueDTOMap.size());
    }

    @Test
    public void whengivenBowlerPath_ShouldReturn_BowlerPlayerMap() {
        IPLCricketLeagueAnalyser iplCricketLeagueAnalyser=new IPLCricketLeagueAnalyser();
        Map<String,IPLCricketLeagueDTO> iplCricketLeagueDTOMap=new HashMap();
        when(iplAdapter.loadPlayerData(IPLCricketLeagueAnalyser.PlayerType.BOWLER, BOWLER_CSV_FILE_PATH)).thenReturn(bowlerList);
        iplCricketLeagueAnalyser.setIPLAdaptor(iplAdapter);
        iplCricketLeagueDTOMap=iplCricketLeagueAnalyser.loadData(IPLCricketLeagueAnalyser.PlayerType.BOWLER, BOWLER_CSV_FILE_PATH);
        System.out.println(iplCricketLeagueDTOMap.size());
    }
}
