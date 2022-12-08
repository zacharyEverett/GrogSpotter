package com.techelevator.dao;

import com.techelevator.model.dto.BeerReviewDto;
import com.techelevator.model.dto.BreweryReviewDto;
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
        String sql = "SELECT beer_name, brewery_name, username, review_id, u.user_id, rating, review_body FROM reviews AS r\n" +
                "JOIN beers AS b ON b.beer_id = r.beer_id\n" +
                "JOIN breweries AS br ON br.brewery_id = b.brewery_id\n" +
                "JOIN users AS u ON u.user_id = r.user_id\n" +
                "ORDER BY rating DESC, username;";
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
        String sql = "SELECT brewery_name, username, review_id, u.user_id, rating, review_body FROM reviews AS r\n" +
                "JOIN breweries AS br ON br.brewery_id = r.brewery_id\n" +
                "JOIN users AS u on u.user_id = r.user_id\n" +
                "ORDER BY rating DESC, username;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Review review = mapRowToReviewBrewery(results);
            reviews.add(review);
        }
        return reviews;
    }

    @Override
    public List<Review> getReviewsByUserId(int userId) {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT beer_name, brewery_name, username, review_id, u.user_id, rating, review_body FROM reviews AS r \n" +
                "JOIN users AS u ON u.user_id = r.user_id\n" +
                "LEFT JOIN beers AS b ON b.beer_id = r.beer_id\n" +
                "LEFT JOIN breweries AS br ON br.brewery_id = r.brewery_id\n" +
                "WHERE u.user_id = ?\n" +
                "ORDER BY rating DESC, username;";
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
        String sql = "SELECT beer_name, brewery_name, username, review_id, r.user_id, rating, review_body FROM reviews AS r\n" +
                "LEFT JOIN beers AS b ON b.beer_id = r.beer_id\n" +
                "LEFT JOIN breweries AS br ON br.brewery_id = b.brewery_id\n" +
                "LEFT JOIN users AS u ON u.user_id = r.user_id\n" +
                "WHERE r.beer_id = ?\n" +
                "ORDER BY rating DESC, username;";
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
        String sql = "SELECT brewery_name, username, review_id, r.user_id, rating, review_body FROM reviews AS r\n" +
                "JOIN breweries AS b ON b.brewery_id = r.brewery_id\n" +
                "JOIN users AS u ON u.user_id = r.user_id\n" +
                "WHERE b.brewery_id = ?\n" +
                "ORDER BY rating DESC, username;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryId);
        while(results.next()){
            Review review = mapRowToReviewBrewery(results);
            reviews.add(review);
        }
        return reviews;
    }

    @Override
    public Review getReviewByReviewId(int reviewId){
        Review review = new Review();
        String sql = "SELECT review_id, user_id, beer_id, brewery_id, rating, review_body FROM reviews\n" +
                "WHERE review_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, reviewId);
        if(results.next()){
            return mapRowToReview(results);
        }else{
            return null;
        }
    }

    @Override
    public Review addBreweryReview(BreweryReviewDto reviewDto){
        Review reviewToAdd;
        Integer reviewId = 0;
        String sql = "INSERT INTO reviews (user_id,title,brewery_id,rating,review_body)" +
                "VALUES (?,?,?,?,?) RETURNING review_id;";
        reviewId = jdbcTemplate.queryForObject(sql, Integer.class, reviewDto.getUserId(),reviewDto.getTitle(),
                reviewDto.getBreweryId(),reviewDto.getRating(),reviewDto.getReviewBody());
        reviewToAdd = getReviewByReviewId(reviewId);
        return reviewToAdd;
    }

    @Override
    public Review addBeerReview(BeerReviewDto reviewDto) {
        Review reviewToAdd;
        Integer reviewId = 0;
        String sql = "INSERT INTO reviews (user_id,title,beer_id,rating,review_body)" +
                "VALUES (?,?,?,?,?) RETURNING review_id;";
        reviewId = jdbcTemplate.queryForObject(sql, Integer.class, reviewDto.getUserId(),reviewDto.getTitle(),
                reviewDto.getBeerId(),reviewDto.getRating(),reviewDto.getReviewBody());
        reviewToAdd = getReviewByReviewId(reviewId);
        return reviewToAdd;
    }

    private Review mapRowToReview(SqlRowSet rs){
        Review review = new Review();
        review.setBeerName(rs.getString("beer_name"));
        review.setBreweryName(rs.getString("brewery_name"));
        review.setUserName(rs.getString("username"));
        review.setReviewId(rs.getInt("review_id"));
        review.setUserId(rs.getInt("user_id"));
        review.setRating(rs.getInt("rating"));
        review.setReviewBody(rs.getString("review_body"));
        return review;
    }

    private Review mapRowToReviewBrewery(SqlRowSet rs){
        Review review = new Review();
        review.setBreweryName(rs.getString("brewery_name"));
        review.setUserName(rs.getString("username"));
        review.setReviewId(rs.getInt("review_id"));
        review.setUserId(rs.getInt("user_id"));
        review.setRating(rs.getInt("rating"));
        review.setReviewBody(rs.getString("review_body"));
        return review;
    }
}
