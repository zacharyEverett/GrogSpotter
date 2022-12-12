package com.techelevator.dao;


import com.techelevator.model.dto.BeerReviewDto;
import com.techelevator.model.dto.BreweryReviewDto;
import com.techelevator.model.app.Review;

import java.util.List;

public interface ReviewDao {
    List<Review> getAllBeerReviews();

    List<Review> getAllBreweryReviews();

    List<Review> getReviewsByUsername(String username);

    List<Review> getReviewsByBeerId(int beerId);

    List<Review> getReviewsByBreweryId(int breweryId);

    Review getBeerReviewByReviewId(int reviewId);

    Review getBreweryReviewByReviewId(int reviewId);

    Review addBreweryReview(BreweryReviewDto reviewDto);

    Review addBeerReview(BeerReviewDto reviewDto);
}
