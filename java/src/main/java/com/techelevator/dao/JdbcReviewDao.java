package com.techelevator.dao;

import com.techelevator.model.app.Review;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcReviewDao implements ReviewDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcReviewDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM reviews WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Review review = mapRowToReview(results);
            reviews.add(review);
        }
        return reviews;
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

    private Review mapRowToReview(SqlRowSet rs){
        Review review = new Review();
        review.setReviewId(rs.getInt("review_id"));
        review.setUserId(rs.getInt("user_id"));
        review.setRating(rs.getInt("rating"));
        review.setReviewBody(rs.getString("review_body"));
        return review;
    }
}
