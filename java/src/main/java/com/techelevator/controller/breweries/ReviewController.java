package com.techelevator.controller.breweries;

import com.techelevator.dao.JdbcReviewDao;
import com.techelevator.model.app.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@CrossOrigin
public class ReviewController {
    /*
    Author: Zachary M.
    Notes: endpoints will need to be revisited with front end team 12/6
    -bring up in standup 12/6
     */

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    JdbcReviewDao reviewDao;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/beers")
    public List<Review> getListOfAllBeerReviews(){
        try{
            return reviewDao.getAllBeerReviews();
        }catch(ResponseStatusException re){
            re.getMessage();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/breweries")
    public List<Review> getListOfAllBreweryReviews(){
        try{
            return reviewDao.getAllBreweryReviews();
        }catch(ResponseStatusException re){
            re.getMessage();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/{userId}")
    public List<Review> getReviewByUserId(@PathVariable int userId){
        try{
            return reviewDao.getReviewsByUserId(userId);
        }catch(ResponseStatusException re){
            re.getMessage();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/beer/{beerId}")
    public List<Review> getReviewByBeerId(@PathVariable int beerId){
        try{
            return reviewDao.getReviewsByBeerId(beerId);
        }catch(ResponseStatusException re){
            re.getMessage();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/brewery/{breweryId}")
    public List<Review> getReviewByBreweryId(@PathVariable int breweryId){
        try{
            return reviewDao.getReviewsByBreweryId(breweryId);
        }catch(ResponseStatusException re){
            re.getMessage();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
