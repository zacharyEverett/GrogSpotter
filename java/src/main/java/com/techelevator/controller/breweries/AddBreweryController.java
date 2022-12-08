package com.techelevator.controller.breweries;


import com.techelevator.dao.JdbcBeerDao;
import com.techelevator.dao.JdbcBreweryDao;
import com.techelevator.model.dto.BreweryDto;
import com.techelevator.model.app.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registerBrewery")
@CrossOrigin
public class AddBreweryController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    JdbcBreweryDao breweriesDao;
    @Autowired
    JdbcBeerDao beerDao;

    @PostMapping("/")
    public Brewery addBrewery(@RequestBody BreweryDto brewery){
        Brewery newBrewery = new Brewery();
        newBrewery = breweriesDao.addBrewery(brewery);
        return newBrewery;
    }

}
