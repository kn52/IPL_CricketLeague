package com.bridgelabz.ipl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ComparatorSort {

    static Map<SortType, Comparator<IPLCricketLeagueDTO>> sortField=new HashMap<>();
    Comparator<IPLCricketLeagueDTO> compare=null;
    public enum SortType{
        BT_AVERAGE,
        BT_STRIKE_RATE,
        BT_SIX_FOUR,
        BT_STRIKE_SIX_FOUR,
        BT_AVERAGE_STRIKE_RATE,
        BT_RUNS_AVERAGE,
        BW_AVERAGE,
        BW_STRIKE_RATE,
        BW_ECONOMY,
        BW_STRIKE_FOURW_FIVEW,
        BW_AVRAGE_STRIKE,
        BW_WICKETS_AVRAGE,
        BT_BW_AVERAGE,
        BT_BW_RUNS_WICKETS,
    }

    public ComparatorSort() {
        compare=Comparator.comparing(x->x.btaverage);
        sortField.put(SortType.BT_AVERAGE,compare);
        sortField.put(SortType.BT_STRIKE_RATE,Comparator.comparing(x->x.btstrikeRate));
        sortField.put(SortType.BT_SIX_FOUR,Comparator.comparing(x->x.sixes+x.fours));

        compare=Comparator.comparing(x->x.sixes+x.fours);
        compare.thenComparing(x->x.btstrikeRate);
        sortField.put(SortType.BT_STRIKE_SIX_FOUR,compare);

        compare=Comparator.comparing(x->x.btaverage);
        compare.thenComparing(x->x.btstrikeRate);
        sortField.put(SortType.BT_AVERAGE_STRIKE_RATE,compare);

        compare=Comparator.comparing(x->x.btaverage);
        compare.thenComparing(x->x.runs);
        sortField.put(SortType.BT_RUNS_AVERAGE,compare);

        sortField.put(SortType.BW_AVERAGE,Comparator.comparing(x->x.blaverage));
        sortField.put(SortType.BW_STRIKE_RATE,Comparator.comparing(x->x.blstrikeRate));
        sortField.put(SortType.BW_ECONOMY,Comparator.comparing(x->x.economy));

        compare=Comparator.comparing(x->x.fiveW+x.fourW);
        compare.thenComparing(x->x.blstrikeRate);
        sortField.put(SortType.BW_STRIKE_FOURW_FIVEW,compare);

        compare=Comparator.comparing(x->x.blaverage);
        compare.thenComparing(x->x.blstrikeRate);
        sortField.put(SortType.BW_AVRAGE_STRIKE,compare);

        compare=Comparator.comparing(x->x.wickets);
        compare.thenComparing(x->x.blaverage);
        sortField.put(SortType.BW_WICKETS_AVRAGE,compare);

        compare=Comparator.comparing(x->x.btaverage+x.blaverage);
        sortField.put(SortType.BT_BW_AVERAGE,compare);

        compare=Comparator.comparing(x->{
            if(x.wickets>7 && x.runs>150)
              return  x.runs-x.wickets;
            return 0;
        });
        sortField.put(SortType.BT_BW_RUNS_WICKETS,compare);


    }

    public static Comparator<IPLCricketLeagueDTO> getComparator(SortType field){
        return sortField.get(field);
    }
}
