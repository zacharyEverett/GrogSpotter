package com.techelevator.dao;

import com.techelevator.model.BreweryDto;
import com.techelevator.model.app.Beer;
import com.techelevator.model.app.Brewery;

import java.util.List;

public interface BreweriesDao {
    List<Brewery> findAll();

    Brewery getBreweryById(int breweryId);

    Brewery getBreweryByName(String breweryName);

    int findBreweryIdByName(String breweryName);

    Brewery addBrewery(BreweryDto brewery);
}
