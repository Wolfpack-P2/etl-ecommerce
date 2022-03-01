package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class QueryResult {

    private String category;
    private String country;
    private int count;
    private int month;
    private int hour;

    public QueryResult(String category, int count) {
        this.category = category;
        this.count = count;
    }

    public QueryResult(String category, String country, int count){
        this.category = category;
        this.country = country;
        this.count = count;
    }

    public QueryResult(String category, int month, int count){
        this.category = category;
        this.month = month;
        this.count = count;
    }

    public QueryResult(String category, String country, int month, int count){
        this.category = category;
        this.country = country;
        this.month = month;
        this.count = count;
    }

    //conflicts with the first constructor
    /*public QueryResult(String country, int count){
        this.country = country;
        this.count = count;
    }*/

    public QueryResult(int hour, int count){
        this.hour = hour;
        this.count = count;
    }

    public QueryResult(int hour, int count, String country){
        this.hour = hour;
        this.count = count;
        this.country = country;
    }

}
