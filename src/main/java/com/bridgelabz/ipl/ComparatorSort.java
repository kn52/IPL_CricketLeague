package com.bridgelabz.ipl;

import java.util.Comparator;

public class ComparatorSort implements Comparator<IPLCricketLeagueDTO> {

    @Override
    public int compare(IPLCricketLeagueDTO dto1, IPLCricketLeagueDTO dto2) {
        return (dto1.sixes+dto1.fours)-(dto2.sixes+dto2.fours);
    }
}
