package com.techelevator.model.dto;

import javax.validation.constraints.NotEmpty;

public class BreweryReviewDto {
    @NotEmpty
    private String username;
    @NotEmpty
    private String title;
    @NotEmpty
    private int breweryId;
    @NotEmpty
    private int rating;
    @NotEmpty
    private String reviewBody;

    public String getUserName() {
        return username;
    }

    public void setUserName(int userId) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
