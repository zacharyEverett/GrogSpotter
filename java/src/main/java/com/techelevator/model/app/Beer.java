package com.techelevator.model.app;

public class Beer {
    private int beerId;
    private String beerName;
    private double abv;
    private String type;
    private String beerDescription;

    public Beer (int beerId, String beerName, double abv, String beerDescription) {
        this.beerId = beerId;
        this.beerName = beerName;
        this.abv = abv;
        this.beerDescription = beerDescription;
    }
    public Beer (){}

    public int getBeerId() {
        return beerId;
    }

    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public double getAbv() {
        return abv;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    public String getType() {
        return type;
    }

    public void setType(String description) {
        this.type = type;
    }

    public String getBeerDescription() {
        return beerDescription;
    }

    public void setBeerDescription(String beerDescription) {
        this.beerDescription = beerDescription;
    }
}
