package com.techelevator.model.dto;

import javax.validation.constraints.NotEmpty;

public class BeerDto {
    @NotEmpty
    private int beerId;
    @NotEmpty
    private int breweryId;
    @NotEmpty
    private String beerName;
    @NotEmpty
    private double abv;
    @NotEmpty
    private String beerType;
    @NotEmpty
    private String beerDescription;

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
