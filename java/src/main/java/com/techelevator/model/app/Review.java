package com.techelevator.model.app;

public class Review {
    private int reviewId;
    private int userId;
    private int beerId;
    private int breweryId;
    private int rating;
    private String reviewBody;

    public Review(int reviewId, int userId, int rating, String reviewBody) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.rating = rating;
        this.reviewBody = reviewBody;
    }
    public Review(){}

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBeerId() {
        return beerId;
    }

    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }

    public int getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(int breweryId) {
        this.breweryId = breweryId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewBody() {
        return reviewBody;
    }

    public void setReviewBody(String reviewBody) {
        this.reviewBody = reviewBody;
    }
}
