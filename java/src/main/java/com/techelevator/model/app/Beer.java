package com.techelevator.model.app;

public class Beer {
    private int beerId;
    private int breweryId;
    private String beerName;
    private double abv;
    private String type;
    private String beerDescription;

    public Beer (int beerId, int breweryId, String beerName, double abv, String type, String beerDescription) {
        this.beerId = beerId;
        this.beerName = beerName;
        this.abv = abv;
        this.type = type;
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
