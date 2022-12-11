package com.techelevator.controller.reviews;

import com.techelevator.dao.JdbcBeerDao;
import com.techelevator.dao.JdbcBreweryDao;
import com.techelevator.dao.JdbcReviewDao;
import com.techelevator.model.dto.BeerReviewDto;
import com.techelevator.model.dto.BreweryReviewDto;
import com.techelevator.model.app.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/breweries/{id}")
@CrossOrigin
public class AddReviewController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    JdbcBreweryDao breweriesDao;
    @Autowired
    JdbcBeerDao beerDao;
    @Autowired
    JdbcReviewDao reviewDao;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Review addBreweryReview(@RequestBody @Valid BreweryReviewDto reviewDto){
        return reviewDao.addBreweryReview(reviewDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{beerID}")
    public Review addBeerReview(@RequestBody @Valid BeerReviewDto reviewDto){
        return reviewDao.addBeerReview(reviewDto);
    }
}

