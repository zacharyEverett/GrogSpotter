package com.techelevator.dao;

import com.techelevator.model.app.Brewery;
import com.techelevator.model.app.Review;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Array;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class JdbcReviewDaoTests extends BaseDaoTests{
    private JdbcReviewDao sut;

    protected static final Review REVIEW_1 = new Review(1, "user", "DRINK THIS ONE!", 5, "It is the greatest beer in all the VERLD!");
    protected static final Review REVIEW_2 = new Review(2, "admin", "Refreshing", 4, "Slimy, yet satisfying!");
    protected static final Review REVIEW_3 = new Review(3, "user", "One of my new favorites!", 5, "5 out of 5!");


    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcReviewDao(jdbcTemplate);
    }

    @Test
    public void getAllBreweryReviewsTest() {
        List<Review> actual = sut.getAllBreweryReviews();
        Assert.assertEquals(3, actual.size());
    }
    @Test
    public void getReviewsByUserIdTest() {
        List<Review> actual = sut.getReviewsByUsername("user");
        Assert.assertEquals(4, actual.size());
    }
    @Test
    public void getReviewsByBeerIdTest() {
        List<Review> actual = sut.getReviewsByBeerId(1);
        Assert.assertEquals(2, actual.size());
    }
    @Test
    public void getReviewsByBreweryId() {
        List<Review> actual = sut.getReviewsByBreweryId(1);
        Assert.assertEquals(2, actual.size());
    }
    @Test
    public void testingAssertBeerMethod() {
        assertBeerReviewsMatch(REVIEW_1, REVIEW_1);
    }
    @Test
    public void testingAssertBreweryMethod() {
        assertBreweryReviewsMatch(REVIEW_1, REVIEW_1);
    }
//    @Test
//    public void getBeerReviewByIdTest() {
//        Review actual = sut.getBeerReviewByReviewId(1);
//        Review expected = REVIEW_1;
//        Assert.assertEquals(actual.getReviewId(), expected.getReviewId());
//    }
//    @Test
//    public void getBreweryReviewByIdTest() {
//        Review actual = sut.getBreweryReviewByReviewId(1);
//        Review expected = REVIEW_1;
//        Assert.assertEquals(actual.getBeerId(), expected.getBeerId());
//    }

    public void assertBeerReviewsMatch(Review expected, Review actual) {
        Assert.assertEquals(expected.getReviewId(), actual.getReviewId());
        Assert.assertEquals(expected.getUsername(), actual.getUsername());
        Assert.assertEquals(expected.getBeerId(), actual.getBeerId());
        Assert.assertEquals(expected.getReviewBody(), actual.getReviewBody());
    }
    public void assertBreweryReviewsMatch(Review expected, Review actual) {
        Assert.assertEquals(expected.getReviewId(), actual.getReviewId());
        Assert.assertEquals(expected.getUsername(), actual.getUsername());
        Assert.assertEquals(expected.getBreweryId(), actual.getBreweryId());
        Assert.assertEquals(expected.getReviewBody(), actual.getReviewBody());
    }
}
