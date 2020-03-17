package com.bridgelabz.ipl;

import com.bridgelabz.census.CSVBuilderFactory;
import com.bridgelabz.census.ICSVBuilder;

import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public abstract class IPLLoader {
    static Iterator playerIterator=null;
    public abstract <E> Map<String,IPLCricketLeagueDTO> loadPlayerData(IPLCricketLeagueAnalyser.PlayerType type, String... csvPath);

    public static <E> Map<String, IPLCricketLeagueDTO> createIterable(Reader reader, Class<E> csvClass, IPLCricketLeagueAnalyser.PlayerType type) {
        Map<String, IPLCricketLeagueDTO> map=new HashMap<>();
        ICSVBuilder csvBuilder = CSVBuilderFactory.createBuilder();
        playerIterator=csvBuilder.getCSVFileIterator(reader,csvClass);
        if(type.equals(IPLCricketLeagueAnalyser.PlayerType.BATSMAN)){
            Iterable<BatsmanCSV> stateCensusIterable = () -> playerIterator ;
            StreamSupport.stream(stateCensusIterable.spliterator(), false)
                    .forEach(batsmanCode -> map.put(batsmanCode.player, new IPLCricketLeagueDTO(batsmanCode)));
        }
        else if(type.equals(IPLCricketLeagueAnalyser.PlayerType.BOWLER)){
            Iterable<BowlerCSV> stateCensusIterable = () -> playerIterator ;
            StreamSupport.stream(stateCensusIterable.spliterator(), false)
                    .forEach(bowlerCode -> map.put(bowlerCode.player, new IPLCricketLeagueDTO(bowlerCode)));
        }
        return map;
    }
}
