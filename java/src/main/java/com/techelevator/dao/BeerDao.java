package com.techelevator.dao;

import com.techelevator.model.app.Beer;

import java.util.List;

public interface BeerDao {

    Beer getById(int beerId);

    List<Beer> getAll();

    List<Beer> getByBreweryId(int brewery_id);

    List<Beer> getByAbv(double abv);

    List<Beer> getByType(String type);

    boolean addBeer(int breweryId, String beerName, double abv, String type, String beerDescription);

}
