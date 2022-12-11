package com.techelevator.model.app;

public class Review {
    private String beerName;
    private String breweryName;
//    private String userName;
    private int reviewId;
    private String username;
    private int beerId;
    private int breweryId;
    private String title;
    private int rating;
    private String reviewBody;

    public Review(int reviewId, String username, String title, int rating, String reviewBody) {
        this.reviewId = reviewId;
        this.username = username;
        this.title = title;
        this.rating = rating;
        this.reviewBody = reviewBody;
    }
    public Review(){}

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public String getBreweryName() {
        return breweryName;
    }

    public void setBreweryName(String breweryName) {
        this.breweryName = breweryName;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

//    public String getUserName() {
//        return username;
//    }

//    public void setUserName(String username) {
//        this.username = username;
//    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
