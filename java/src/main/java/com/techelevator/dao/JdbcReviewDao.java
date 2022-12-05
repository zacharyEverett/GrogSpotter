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
/*
Class Author: Kyle P-N.
Method Author: Zachary M.
Notes: all list methods operate functionally within PGAdmin.
     - Ordered by rating DESC and then by user_id
     - Create reviews may need to be revisited and are not final. See below.
     + add try/catch blocks and exception handling *DEADLINE* Monday
 */
    @Override
    public List<Review> getAllBeerReviews() {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT review_id, user_id, rating, review_body FROM reviews AS r\n" +
                "JOIN beers AS b ON b.beer_id = r.beer_id\n" +
                "ORDER BY rating;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Review review = mapRowToReview(results);
            reviews.add(review);
        }
        return reviews;
    }


    @Override
    public List<Review> getAllBreweryReviews() {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT review_id, user_id, rating, review_body FROM reviews AS r\n" +
                "JOIN breweries AS b ON b.brewery_id = r.brewery_id\n" +
                "ORDER BY rating DESC, user_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Review review = mapRowToReview(results);
            reviews.add(review);
        }
        return reviews;
    }

    @Override
    public List<Review> getReviewsByUserId(int userId) {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT review_id, user_id, rating, review_body\n" +
                "FROM reviews WHERE user_id = ?\n" +
                "ORDER BY rating DESC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()){
            Review review = mapRowToReview(results);
            reviews.add(review);
        }
        return reviews;
    }

    @Override
    public List<Review> getReviewsByBeerId(int beerId) {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT review_id, user_id, rating, review_body FROM reviews AS r\n" +
                "JOIN beers AS b ON b.beer_id = r.beer_id\n" +
                "WHERE b.beer_id = ?\n" +
                "ORDER BY rating DESC, user_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, beerId);
        while(results.next()){
            Review review = mapRowToReview(results);
            reviews.add(review);
        }
        return reviews;
    }

    @Override
    public List<Review> getReviewsByBreweryId(int breweryId) {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT review_id, user_id, rating, review_body FROM reviews AS r\n" +
                "JOIN breweries AS b ON b.brewery_id = r.brewery_id\n" +
                "WHERE b.brewery_id = 1\n" +
                "ORDER BY rating DESC, user_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryId);
        while(results.next()){
            Review review = mapRowToReview(results);
            reviews.add(review);
        }
        return reviews;
    }

    //revisit after controllers are built -----> lines 100-111
    @Override
    public boolean addBeerReview(int user_id,int beerId,int brewery_id,int rating,String review_body) {
        String sql = "INSERT INTO reviews (user_id,beer_id,brewery_id,rating,review_body)\n" +
                "VALUES (?,?,?,?,?);";
        return jdbcTemplate.update(sql, user_id, beerId, brewery_id, rating, review_body)==1;
    }

    @Override
    public boolean addBreweryReview(int user_id,int beerId,int brewery_id,int rating,String review_body) {
        String sql = "INSERT INTO reviews (user_id,beer_id,brewery_id,rating,review_body)\n" +
                "VALUES (?,?,?,?,?);";
        return jdbcTemplate.update(sql, user_id,beerId,brewery_id,rating,review_body)==1;
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
