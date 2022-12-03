package com.techelevator.dao;

import com.techelevator.model.app.Review;

import java.util.List;

public interface ReviewDao {
    List<Review> getAllBeer();

    List<Review> getAllBrewery();

    List<Review> getByUser(int userId);

    List<Review> getByBeer(int beerId);

    List<Review> getByBrewery(int breweryId);

    boolean addBeerReview(int beerId);

    boolean addBreweryReview(int breweryId);
}
