package com.techelevator.model.dto;

import javax.validation.constraints.NotEmpty;

public class BeerReviewDto {
    @NotEmpty
    private String username;
    @NotEmpty
    private String title;
    @NotEmpty
    private int beerId;
    @NotEmpty
    private int rating;
    @NotEmpty
    private String reviewBody;

    public String getUserName() {
        return username;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBeerId() {
        return beerId;
    }

    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }

    public int getRating() {
        return rating;
    }

    public String getReviewBody() {
        return reviewBody;
    }

}
