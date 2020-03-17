package com.bridgelabz.ipl;

public class IPLCricketLeagueDTO {
    public String player;
    public double btaverage;
    public double blaverage;
    public double btstrikeRate;
    public double blstrikeRate;
    public int sixes;
    public int fours;
    public int runs;
    public double economy;
    public int fourW;
    public int fiveW;
    public int wickets;

    public IPLCricketLeagueDTO(BatsmanCSV batsmanCode) {
        this.player=batsmanCode.player;
        this.btaverage=batsmanCode.average;
        this.btaverage=batsmanCode.average;
        this.btstrikeRate=batsmanCode.strikeRate;
        this.fours=batsmanCode.fours;
        this.sixes=batsmanCode.sixes;
        this.runs=batsmanCode.runs;
    }

    public IPLCricketLeagueDTO(BowlerCSV bowlerCode) {
        this.player=bowlerCode.player;
        this.blaverage=bowlerCode.average;
        this.blaverage=bowlerCode.average;
        this.blstrikeRate=bowlerCode.strikeRate;
        this.economy=bowlerCode.economy;
        this.fourW=bowlerCode.fourW;
        this.fiveW=bowlerCode.fiveW;
        this.wickets=bowlerCode.wickets;
    }

    public IPLCricketLeagueDTO() {

    }
}
