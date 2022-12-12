package com.techelevator.controller.breweries;


import com.techelevator.model.app.SearchedBrewery;
import com.techelevator.services.BreweriesSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/search")
public class unverifiedBreweryController {

BreweriesSearchService searchService = new BreweriesSearchService();

    @GetMapping("/{city}")
    public SearchedBrewery[] search(@PathVariable String city){
    return searchService.search(city);
    }

}
