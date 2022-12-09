package com.techelevator.model.app;

public class Beer {
    private int beerId;
    private int breweryId;
    private String beerName;
    private double abv;
    private String beerType;
    private String beerDescription;

    public Beer (int beerId, int breweryId, String beerName, double abv, String type, String beerDescription) {
        this.beerId = beerId;
        this.beerName = beerName;
        this.abv = abv;
        this.beerType = type;
        this.beerDescription = beerDescription;
    }
    public Beer (){}

    public int getBeerId() {
        return beerId;
    }

    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }

    public int getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(int breweryId) {
        this.breweryId = breweryId;
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

    public String getBeerType() {
        return beerType;
    }

    public void setBeerType(String beerType) {
        this.beerType = beerType;
    }

    public String getBeerDescription() {
        return beerDescription;
    }

    public void setBeerDescription(String beerDescription) {
        this.beerDescription = beerDescription;
    }
}
