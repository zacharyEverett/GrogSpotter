package com.techelevator.dao;

import com.techelevator.model.dto.BreweryDto;
import com.techelevator.model.app.Brewery;

import java.util.List;

public interface BreweriesDao {
    List<Brewery> findAll();

    Brewery getBreweryById(int breweryId);

    Brewery getBreweryByName(String breweryName);

    int findBreweryIdByName(String breweryName);

    List<Brewery> findBreweryByBrewerId(int brewerId);

    Brewery addBrewery(BreweryDto brewery);

    Brewery updateBrewery(BreweryDto brewery, int breweryId);
}
