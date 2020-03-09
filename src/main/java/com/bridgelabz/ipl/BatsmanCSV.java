package com.bridgelabz.ipl;

import com.opencsv.bean.CsvBindByName;

public class BatsmanCSV {

    @CsvBindByName(column ="PLAYER" , required = true )
    public String player;
    @CsvBindByName(column = "Avg" , required = true)
    public double average;
    @CsvBindByName(column = "SR" , required = true)
    public double strikeRate;
    @CsvBindByName(column = "6s" , required = true)
    public int sixes;
    @CsvBindByName(column = "4s" , required = true)
    public int fours;
    @CsvBindByName(column="Runs",required = true)
    public int runs;

}
