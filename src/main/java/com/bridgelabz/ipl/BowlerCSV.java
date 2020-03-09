package com.bridgelabz.ipl;

import com.opencsv.bean.CsvBindByName;

public class BowlerCSV {
    @CsvBindByName(column="PLAYER" , required = true)
    public String player;
    @CsvBindByName(column="Avg" , required = true)
    public double average;
    @CsvBindByName(column="SR" , required = true)
    public double strikeRate;
    @CsvBindByName(column="Econ" , required = true)
    public double economy;
    @CsvBindByName(column="4w" , required = true)
    public int fourW;
    @CsvBindByName(column="5w" , required = true)
    public int fiveW;
    @CsvBindByName(column="Wkts" , required = true)
    public int wickets;
}
