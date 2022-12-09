package com.techelevator.model.dto;

import javax.validation.constraints.NotEmpty;
import java.time.LocalTime;

public class BreweryDto {
    @NotEmpty
    private int breweryID;
    @NotEmpty
    private String breweryName;
    @NotEmpty
    private String streetAddress;
    @NotEmpty
    private String city;
    @NotEmpty
    private String stateAbv;
    @NotEmpty
    private String zip;
    @NotEmpty
    private LocalTime timeOpen;
    @NotEmpty
    private LocalTime timeClosed;
    @NotEmpty
    private String history;
    @NotEmpty
    private boolean isActive = true;

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

    public void setBreweryAddress(String breweryAddress) {
        this.streetAddress = breweryAddress;
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
}
