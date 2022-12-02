package com.techelevator.dao;

import com.techelevator.model.app.Beer;

import java.util.List;

public interface BeerDao {
    List<Beer> getAll();

    List<Beer> getByBreweryId();

    List<Beer> getByAbv();

    List<Beer> getByType();

}
