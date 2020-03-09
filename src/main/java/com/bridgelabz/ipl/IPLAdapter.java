package com.bridgelabz.ipl;

import com.bridgelabz.census.CSVBuilderException;
import com.bridgelabz.census.CSVBuilderFactory;
import com.bridgelabz.census.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public abstract class IPLAdapter {
    public abstract Map<String, IPLCricketLeagueDTO> loadPlayerData(String... csvPath);

    protected  <E> Map<String,IPLCricketLeagueDTO> loadPlayerData(Class<E> csvClass, String csvPath) {
        Map<String, IPLCricketLeagueDTO> map=new HashMap<>();
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvPath));
            ICSVBuilder csvBuilder=CSVBuilderFactory.createBuilder();
            Iterator<E> playerIterator= csvBuilder.getCSVFileIterator(reader, csvClass);
            Iterable<E> stateCensusIterable=()->playerIterator;
            if (csvClass.getName().equals("com.bridgelabz.ipl.BatsmanCSV")){
                StreamSupport.stream(stateCensusIterable.spliterator(),false)
                        .map(BatsmanCSV.class::cast)
                        .forEach(batsmanCode -> map.put(batsmanCode.player,new IPLCricketLeagueDTO(batsmanCode)));
            }
            else if(csvClass.getName().equals("com.bridgelabz.ipl.BowlerCSV")){
                StreamSupport.stream(stateCensusIterable.spliterator(),false)
                        .map(BowlerCSV.class::cast)
                        .forEach(bowlerCode -> map.put(bowlerCode.player,new IPLCricketLeagueDTO(bowlerCode)));
            }
            return map;
        }catch (NoSuchFileException e){}
        catch (IOException ioe) {
            throw new IPLCricketLeagueAnalyserException(ioe.getMessage(),IPLCricketLeagueAnalyserException.ExceptionType.FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new IPLCricketLeagueAnalyserException("Incorrect",e.getMessage());
        }catch (RuntimeException e){
            throw new IPLCricketLeagueAnalyserException(e.getMessage(),IPLCricketLeagueAnalyserException.ExceptionType.FILE_PROBLEM);
        }
        return null;
    }
}
