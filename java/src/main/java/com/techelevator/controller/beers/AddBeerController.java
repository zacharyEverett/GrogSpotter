package com.techelevator.controller.beers;

import com.techelevator.dao.JdbcBeerDao;
import com.techelevator.dao.JdbcBreweryDao;
import com.techelevator.model.dto.BeerDto;
import com.techelevator.model.app.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addBeer")
@CrossOrigin
public class AddBeerController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    JdbcBreweryDao breweriesDao;
    @Autowired
    JdbcBeerDao beerDao;

    @PostMapping("/")
    public Beer addBeer(@RequestBody BeerDto beer){
        Beer newBeer = new Beer();
        newBeer = beerDao.addBeer(beer);
        return newBeer;
    }
}
