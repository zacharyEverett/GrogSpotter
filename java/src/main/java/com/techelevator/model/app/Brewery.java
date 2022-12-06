package com.techelevator.model.app;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

public class Brewery {

    private int breweryID;
    private String breweryName;
    private String breweryAddress;
    private LocalTime timeOpen;
    private LocalTime timeClosed;
    private String history;
    private boolean isActive = true;


    public Brewery (int breweryID, String breweryName, String breweryAddress, LocalTime timeOpen, LocalTime timeClosed, String history, boolean isActive){
        this.breweryID = breweryID;
        this.breweryName = breweryName;
        this.breweryAddress = breweryAddress;
        this.timeOpen = timeOpen;
        this.timeClosed = timeClosed;
        this.history = history;
        this.isActive = isActive;
    }
    public Brewery(){}

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

    public LocalTime getTimeOpen() {
        return timeOpen;
    }

    public void setTimeOpen(LocalTime timeOpen) {
        this.timeOpen = timeOpen;
    }

    public LocalTime getTimeClosed() {
        return timeClosed;
    }

    public void setTimeClosed(LocalTime timeClosed) {
        this.timeClosed = timeClosed;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Beer> getBeersList() {
        return beersList;
    }

    public void setBeersList(List<Beer> beersList) {
        this.beersList = beersList;
    }
}
