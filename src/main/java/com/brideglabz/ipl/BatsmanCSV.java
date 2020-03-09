package com.brideglabz.ipl;

import com.opencsv.bean.CsvBindByName;

public class BatsmanCSV {
//    POS,PLAYER,Mat,Inns,NO,Runs,HS,Avg,BF,SR,100,50,4s,6s

    @CsvBindByName(column ="PLAYER" , required = true )
    public String player;
    @CsvBindByName(column = "Avg" , required = true)
    public double average;
}
