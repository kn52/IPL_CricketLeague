package com.bridgelabz.ipl;

public class IPLCricketLeagueDTO {
    public String player;
    public double average;
    public double strikeRate;
    public int sixes;
    public int fours;
    public int runs;
    public double economy;
    public int fourW;
    public int fiveW;
    public int wickets;

    public IPLCricketLeagueDTO(BatsmanCSV batsmanCode) {
        this.player=batsmanCode.player;
        this.average=batsmanCode.average;
        this.strikeRate=batsmanCode.strikeRate;
        this.fours=batsmanCode.fours;
        this.sixes=batsmanCode.sixes;
        this.runs=batsmanCode.runs;
    }

    public IPLCricketLeagueDTO(BowlerCSV bowlerCode) {
        this.player=bowlerCode.player;
        this.average=bowlerCode.average;
        this.strikeRate=bowlerCode.strikeRate;
        this.economy=bowlerCode.economy;
        this.fourW=bowlerCode.fourW;
        this.fiveW=bowlerCode.fiveW;
        this.wickets=bowlerCode.wickets;
    }
}
