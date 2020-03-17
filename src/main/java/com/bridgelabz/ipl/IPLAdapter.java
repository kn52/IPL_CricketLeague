package com.bridgelabz.ipl;

import com.bridgelabz.census.CSVBuilderException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class IPLAdapter extends IPLLoader{
    static Map<String, IPLCricketLeagueDTO> map0=null;
    static Map<String, IPLCricketLeagueDTO> map1=null;

    @Override
    public <E> Map<String,IPLCricketLeagueDTO> loadPlayerData(IPLCricketLeagueAnalyser.PlayerType type, String... csvPath) {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvPath[0]));){
            if(type.equals(IPLCricketLeagueAnalyser.PlayerType.BATSMAN)) {
                map0=new HashMap<>();
                map0=createIterable(reader,BatsmanCSV.class,type);
                if(csvPath.length>1){
                    return  loadData(csvPath[1]);
                }
                return map0;
            }
            else if(type.equals(IPLCricketLeagueAnalyser.PlayerType.BOWLER)){
                map1=new HashMap<>();
                map1=createIterable(reader,BowlerCSV.class, type);
                return map1;
            }

        }catch (NoSuchFileException e){}
        catch (IOException ioe) {
            throw new IPLCricketLeagueAnalyserException(ioe.getMessage(),IPLCricketLeagueAnalyserException.ExceptionType.FILE_PROBLEM);
        }catch (RuntimeException e){
            throw new IPLCricketLeagueAnalyserException(e.getMessage(),IPLCricketLeagueAnalyserException.ExceptionType.FILE_PROBLEM);
        }
        return null;
    }

    private static <E> Map<String, IPLCricketLeagueDTO> loadData(String csvPath) {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvPath));) {
            map1=new HashMap<>();
            map1=createIterable(reader,BowlerCSV.class,IPLCricketLeagueAnalyser.PlayerType.BOWLER);
            map1.values().stream()
                    .filter(data-> IPLAdapter.map0.get(data.player)!=null)
                    .forEach(data->{
                        IPLAdapter.map0.get(data.player).blaverage=data.blaverage;
                        IPLAdapter.map0.get(data.player).wickets = data.wickets;
                    });
            return map0;
        }catch (IOException ioe) {
            throw new IPLCricketLeagueAnalyserException(ioe.getMessage(), IPLCricketLeagueAnalyserException.ExceptionType.FILE_PROBLEM);
        } catch (RuntimeException e) {
            throw new IPLCricketLeagueAnalyserException(e.getMessage(), IPLCricketLeagueAnalyserException.ExceptionType.FILE_PROBLEM);
        }
    }
}
