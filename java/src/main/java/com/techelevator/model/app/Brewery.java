package com.techelevator.model.app;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

public class Brewery {

    private int breweryID;
    private String breweryName;
    private String streetAddress;
    private String city;
    private String stateAbv;
    private String zip;
    private LocalTime timeOpen;
    private LocalTime timeClosed;
    private String history;
    private boolean isActive = true;


    public Brewery (int breweryID, String breweryName, String streetAddress, String city, String stateAbv, String zip, LocalTime timeOpen, LocalTime timeClosed, String history, boolean isActive){
        this.breweryID = breweryID;
        this.breweryName = breweryName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.stateAbv = stateAbv;
        this.zip = zip;
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

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateAbv() {
        return stateAbv;
    }

    public void setStateAbv(String stateAbv) {
        this.stateAbv = stateAbv;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
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
