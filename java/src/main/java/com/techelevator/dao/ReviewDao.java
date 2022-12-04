package com.techelevator.dao;

import com.techelevator.model.app.Review;

import java.util.List;

public interface ReviewDao {
    List<Review> getAllBeerReviews();

    List<Review> getAllBreweryReviews();

    List<Review> getReviewsByUserId(int userId);

    List<Review> getReviewsByBeerId(int beerId);

    List<Review> getReviewsByBreweryId(int breweryId);

    boolean addBeerReview(int user_id,int beerId,int brewery_id,int rating,String review_body);

    boolean addBreweryReview(int user_id,int beerId,int brewery_id,int rating,String review_body);
}
