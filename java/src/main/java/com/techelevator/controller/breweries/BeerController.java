package com.techelevator.controller.breweries;

import com.techelevator.dao.JdbcBeerDao;
import com.techelevator.model.app.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/beers")
@CrossOrigin
public class BeerController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    JdbcBeerDao beerDao;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Beer

}
