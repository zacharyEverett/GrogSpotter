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
//        String sql = "SELECT beer_name, brewery_name, r.username, review_id, u.user_id, rating, review_body FROM reviews AS r\n" +
//                "JOIN beers AS b ON b.beer_id = r.beer_id\n" +
//                "JOIN breweries AS br ON br.brewery_id = b.brewery_id\n" +
//                "JOIN users AS u ON u.username = r.username\n" +
//                "ORDER BY review_id DESC;";
        String sql = "select review_id, beer_id from reviews where beer_id is not null;";
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
        String sql = "SELECT brewery_name, r.username, review_id, u.user_id, title, rating, review_body FROM reviews AS r\n" +
                "JOIN breweries AS br ON br.brewery_id = r.brewery_id\n" +
                "JOIN users AS u on u.username = r.username\n" +
                "ORDER BY review_id DESC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Review review = mapRowToReviewBrewery(results);
            reviews.add(review);
        }
        return reviews;
    }

    @Override
    public List<Review> getReviewsByUsername(String username) {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT beer_name, brewery_name, r.username, review_id, title, rating, review_body FROM reviews AS r \n" +
                "JOIN users AS u ON u.username = r.username\n" +
                "LEFT JOIN beers AS b ON b.beer_id = r.beer_id\n" +
                "LEFT JOIN breweries AS br ON br.brewery_id = r.brewery_id\n" +
                "WHERE u.username = ?\n" +
                "ORDER BY review_id DESC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
        while(results.next()){
            Review review = mapRowToReview(results);
            reviews.add(review);
        }
        return reviews;
    }

    @Override
    public List<Review> getReviewsByBeerId(int beerId) {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT beer_name, brewery_name, r.username, review_id, title, rating, review_body FROM reviews AS r\n" +
                "LEFT JOIN beers AS b ON b.beer_id = r.beer_id\n" +
                "LEFT JOIN breweries AS br ON br.brewery_id = b.brewery_id\n" +
                "LEFT JOIN users AS u ON u.username = r.username\n" +
                "WHERE r.beer_id = ?\n" +
                "ORDER BY review_id DESC;";
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
        String sql = "SELECT brewery_name, r.username, review_id, u.user_id, title, rating, review_body FROM reviews AS r\n" +
                "JOIN breweries AS b ON b.brewery_id = r.brewery_id\n" +
                "JOIN users AS u ON u.username = r.username\n" +
                "WHERE b.brewery_id = ?\n" +
                "ORDER BY review_id DESC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryId);
        while(results.next()){
            Review review = mapRowToReviewBrewery(results);
            reviews.add(review);
        }
        return reviews;
    }

    @Override
    public Review getBeerReviewByReviewId(int reviewId){
        Review review = new Review();
        String sql = "SELECT review_id, username, beer_id, title, rating, review_body FROM reviews\n" +
                "WHERE review_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, reviewId);
        if(results.next()){
            return mapRowToReview(results);
        }else{
            return null;
        }
    }
    @Override
    public Review getBreweryReviewByReviewId(int reviewId){
        Review review = new Review();
        String sql = "SELECT review_id, username, brewery_id, title, rating, review_body FROM reviews\n" +
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
        String sql = "INSERT INTO reviews (username,title,brewery_id,rating,review_body)" +
                "VALUES (?,?,?,?,?) RETURNING review_id;";
        reviewId = jdbcTemplate.queryForObject(sql, Integer.class, reviewDto.getUsername(),reviewDto.getTitle(),
                reviewDto.getBreweryId(),reviewDto.getRating(),reviewDto.getReviewBody());
        reviewToAdd = getBreweryReviewByReviewId(reviewId);
        return reviewToAdd;
    }

    @Override
    public Review addBeerReview(BeerReviewDto reviewDto) {
        Review reviewToAdd;
        Integer reviewId = 0;
        String sql = "INSERT INTO reviews (username,title,beer_id,rating,review_body)" +
                "VALUES (?,?,?,?,?) RETURNING review_id;";
        reviewId = jdbcTemplate.queryForObject(sql, Integer.class, reviewDto.getUsername(),reviewDto.getTitle(),
                reviewDto.getBeerId(),reviewDto.getRating(),reviewDto.getReviewBody());
        reviewToAdd = getBeerReviewByReviewId(reviewId);
        return reviewToAdd;
    }

    private Review mapRowToReview(SqlRowSet rs){
        Review review = new Review();
        review.setBeerName(rs.getString("beer_name"));
        review.setBreweryName(rs.getString("brewery_name"));
        review.setUsername(rs.getString("username"));
        review.setReviewId(rs.getInt("review_id"));
        review.setUsername(rs.getString("username"));
        review.setTitle(rs.getString("title"));
        review.setRating(rs.getInt("rating"));
        review.setReviewBody(rs.getString("review_body"));
        return review;
    }

    private Review mapRowToReviewBrewery(SqlRowSet rs){
        Review review = new Review();
        review.setBreweryName(rs.getString("brewery_name"));
        review.setUsername(rs.getString("username"));
        review.setReviewId(rs.getInt("review_id"));
        review.setTitle(rs.getString("title"));
        review.setRating(rs.getInt("rating"));
        review.setReviewBody(rs.getString("review_body"));
        return review;
    }
}
