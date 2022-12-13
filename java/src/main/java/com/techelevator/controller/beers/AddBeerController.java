package com.techelevator.controller.beers;

import com.techelevator.dao.JdbcBeerDao;
import com.techelevator.dao.JdbcBreweryDao;
import com.techelevator.model.dto.BeerDto;
import com.techelevator.model.app.Beer;
import com.techelevator.model.dto.FavoritedBeerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping()
    public Beer addBeer(@RequestBody BeerDto beer){
        Beer newBeer = new Beer();
        newBeer = beerDao.addBeer(beer);
        return newBeer;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/favorites")
    public Beer addFavorite(@RequestBody FavoritedBeerDTO entry){
        Beer newFavorite = beerDao.addFavorite(entry);
        return newFavorite;
    }
}
