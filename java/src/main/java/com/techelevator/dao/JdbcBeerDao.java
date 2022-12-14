package com.techelevator.dao;


import com.techelevator.model.dto.BeerDto;
import com.techelevator.model.dto.FavoritedBeerDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import com.techelevator.model.app.Beer;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBeerDao implements BeerDao{
    private final JdbcTemplate jdbcTemplate;
    public JdbcBeerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Beer getById(int beerID) {
        String sql = "SELECT beer_id, brewery_id, beer_name, brewery_name, abv, beer_type, beer_description FROM beers JOIN breweries USING (brewery_id) WHERE beer_id = ? ORDER BY beer_name;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, beerID);
        if (results.next()) {
            return mapRowToBeer(results);
        } else {
            return null;
        }
    }

    @Override
    public List<Beer> getAll() {
        List<Beer> beers = new ArrayList<>();
        String sql = "SELECT beer_id, brewery_id, beer_name, brewery_name, abv, beer_type, beer_description " +
                "FROM beers JOIN breweries USING (brewery_id) ORDER BY beer_name; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Beer beer = mapRowToBeer(results);
            beers.add(beer);
        }
        return beers;
    }

    @Override
    public List<Beer> getByBreweryId(int brewery_id) {
        List<Beer> beers = new ArrayList<>();
        String sql = "SELECT beer_id, brewery_id, beer_name, brewery_name, abv, beer_type, beer_description " +
                "FROM beers JOIN breweries USING (brewery_id) WHERE brewery_id = ? ORDER BY beer_name;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, brewery_id);
        while (results.next()) {
            Beer beer = mapRowToBeer(results);
            beers.add(beer);
        }
        return beers;
    }

    @Override
    public List<Beer> getByAbv(double abv) {
        List<Beer> beers = new ArrayList<>();
        String sql = "SELECT beer_id, brewery_id, beer_name, brewery_name, abv, beer_type, beer_description " +
                "FROM beers JOIN breweries USING (brewery_id) WHERE abv > ? ORDER BY beer_name;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, abv);
        while (results.next()) {
            Beer beer = mapRowToBeer(results);
            beers.add(beer);
        }
        return beers;
    }

    @Override
    public List<Beer> getByType(String type) {
        List<Beer> beers = new ArrayList<>();
        String sql = "SELECT beer_id, brewery_id, beer_name, brewery_name, abv, beer_type, beer_description " +
                "FROM beers JOIN breweries USING (brewery_id) WHERE type = ? ORDER BY beer_name;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, type);
        while (results.next()) {
            Beer beer = mapRowToBeer(results);
            beers.add(beer);
        }
        return beers;
    }

    @Override
    public Beer addBeer(BeerDto beer) {
        Integer beerId = 0;
        Beer beer1 = new Beer();
        String sql = "INSERT into beers (brewery_id, beer_name, abv, beer_type, beer_description) VALUES (?, ?, ?, ?, ?) RETURNING beer_id;";
        beerId = jdbcTemplate.queryForObject(sql, Integer.class, beer.getBreweryId(), beer.getBeerName(), beer.getAbv(), beer.getBeerType(), beer.getBeerDescription());
        beer1 = getById(beerId);
        return beer1;
//        return jdbcTemplate.update(sql, breweryId, beerName, abv, type, beerDescription) == 1;
    }

    public Beer addFavorite(FavoritedBeerDTO fav){
        Beer beer;
        int beerId = 0;
        String sql = "INSERT INTO user_beers (user_id, beer_id) VALUES (?,?) RETURNING beer_id";
        beerId = jdbcTemplate.queryForObject(sql, Integer.class, fav.getUser_id(), fav.getBeer_id());
        beer = getById(beerId);
        return beer;
    }

    public List<Beer> getFavorites(int userId){
        List<Beer> favorites = new ArrayList<>();
        String sql = "SELECT beer_id, brewery_id, beer_name, abv, beer_type, beer_description " +
                "FROM beers JOIN user_beers USING (beer_id) where user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            Beer beer = mapRowToBeer(results);
            favorites.add(beer);
        }
        return favorites;
    }

    public void deleteFavorite(FavoritedBeerDTO fav){
        String sql = "DELETE from user_beers where user_id = ? AND beer_id = ?";
        jdbcTemplate.update(sql, fav.getUser_id(), fav.getBeer_id());
    }
    public void deleteBeer(int beerId) {
        String sql = "DELETE from beers where beer_id = ?;";
        jdbcTemplate.update(sql, beerId);
    }

    private Beer mapRowToBeer(SqlRowSet rs) {
        Beer beer = new Beer();
        beer.setBeerId(rs.getInt("beer_id"));
        beer.setBreweryId(rs.getInt("brewery_id"));
        beer.setBeerName(rs.getString("beer_name"));
        beer.setAbv(rs.getDouble("abv"));
        beer.setBeerType(rs.getString("beer_type"));
        beer.setBeerDescription(rs.getString("beer_description"));
        return beer;
    }






}
