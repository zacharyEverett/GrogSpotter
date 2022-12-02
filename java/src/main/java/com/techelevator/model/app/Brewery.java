package com.techelevator.model.app;

import java.util.List;

public class Brewery {
    private int breweryID;

    private String breweryName;

    private String breweryAddress;

    private List<Beer> beersList;

    public int getBreweryID() {
        return breweryID;
    }

    public void setBreweryID(int breweryID) {
        this.breweryID = breweryID;
    }

    public String getBreweryName() {
        return breweryName;
    }

    public void setBreweryName(String breweryName) {
        this.breweryName = breweryName;
    }

    public String getBreweryAddress() {
        return breweryAddress;
    }

    public void setBreweryAddress(String breweryAddress) {
        this.breweryAddress = breweryAddress;
    }

    public List<Beer> getBeersList() {
        return beersList;
    }

    public void setBeersList(List<Beer> beersList) {
        this.beersList = beersList;
    }
}
