package com.techelevator.controller.beers;

import com.techelevator.dao.JdbcBeerDao;
import com.techelevator.model.app.Beer;
import com.techelevator.model.dto.FavoritedBeerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/beers")
@CrossOrigin
public class    BeerController {
    /*
    Author: Zachary M.
    Notes: need input on endpoints to finish methods. Same problem we were having with column not
    exiting when I run this in pgAdmin.
    -will discuss in standup 12/6
     */

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    JdbcBeerDao beerDao;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Beer> getListOfAllBeer(){
        try{
            return beerDao.getAll();
        }catch(ResponseStatusException re){
            re.getMessage();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{beerId}")
    public Beer getBeerByBeerId(@PathVariable int beerId){
        try{
            return beerDao.getById(beerId);
        }catch (ResponseStatusException re){
            re.getMessage();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/favorites/{userId}")
    public List<Beer> getFavorites(@PathVariable int userId){
        try {
            return beerDao.getFavorites(userId);
        } catch (ResponseStatusException re){
            re.getMessage();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This is actually a delete-endpoint, despite the put mapping, but axios is mean
     * and hates deletes. So I had to make it puts, now it works. I hate it.
     * - Zach E
     * @param fav
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/favorites")
    public void deleteFavorite(@RequestBody FavoritedBeerDTO fav) {
        try {
            beerDao.deleteFavorite(fav);
        } catch (ResponseStatusException re){
            re.getMessage();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






}
