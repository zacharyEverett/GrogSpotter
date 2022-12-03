package com.techelevator.dao;

import com.techelevator.model.app.Review;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcReviewDao implements ReviewDao {

    @Override
    public List<Review> getAllBeer() {
        return null;
    }

    @Override
    public List<Review> getAllBrewery() {
        return null;
    }

    @Override
    public List<Review> getByUser(int userId) {
        return null;
    }

    @Override
    public List<Review> getByBeer(int beerId) {
        return null;
    }

    @Override
    public List<Review> getByBrewery(int breweryId) {
        return null;
    }

    @Override
    public boolean addBeerReview(int beerId) {
        return false;
    }

    @Override
    public boolean addBreweryReview(int breweryId) {
        return false;
    }
}
