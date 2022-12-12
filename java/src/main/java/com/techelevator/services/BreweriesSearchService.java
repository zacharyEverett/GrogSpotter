package com.techelevator.services;

import com.techelevator.model.app.Brewery;
import com.techelevator.model.app.SearchedBrewery;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class BreweriesSearchService {
    private RestTemplate restTemplate = new RestTemplate();
    private String API_BASE_URL = "https://api.openbrewerydb.org/breweries?by_city=";

    public SearchedBrewery[] search(String city){
        SearchedBrewery[] breweryList = restTemplate.getForObject(API_BASE_URL + city, SearchedBrewery[].class);
        return breweryList;

    }
}
