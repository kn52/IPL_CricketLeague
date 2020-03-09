package com.brideglabz.ipl;

import com.bridgelabz.census.CSVBuilderFactory;
import com.bridgelabz.census.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IPLCricketLeagueAnalyser {
    List<BatsmanCSV> csvList=null;
    public void loadData(String csvFilePath) {
            try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
                ICSVBuilder icsvBuilder = CSVBuilderFactory.createBuilder();
                csvList = icsvBuilder.getCSVFileList(reader, BatsmanCSV.class);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (RuntimeException e) {
                throw new IPLCricketLeagueAnalyserException("INCORRECT", IPLCricketLeagueAnalyserException.ExceptionType.FILE_PROBLEM);
            }
        }

    public String getSortByAverage() {
        return csvList.stream()
                .sorted(Comparator.comparing(x -> x.average, Comparator.reverseOrder()))
                .collect(Collectors.toList()).get(0).player;
    }

    public String getSortByStrike() {
        return csvList.stream()
                .sorted(Comparator.comparing(x -> x.strikeRate, Comparator.reverseOrder()))
                .collect(Collectors.toList()).get(0).player;
    }
}
