package com.techelevator.dao;


import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import com.techelevator.model.app.Beer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JdbcBeerDao implements BeerDao{
    private final JdbcTemplate jdbcTemplate;
    public JdbcBeerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Beer getById(int beerID) {
        String sql = "SELECT beer_id, beer_name, brewery_name, abv, beer_type, beer_description FROM beers JOIN breweries USING (brewery_id) WHERE beer_id = ? ORDER BY beer_name;";
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
        String sql = "SELECT beer_id, beer_name, brewery_name, abv, beer_type, beer_description " +
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
        String sql = "SELECT beer_id, beer_name, brewery_name, abv, beer_type, beer_description " +
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
        String sql = "SELECT beer_id, beer_name, brewery_name, abv, beer_type, beer_description " +
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
        String sql = "SELECT beer_id, beer_name, brewery_name, abv, beer_type, beer_description " +
                "FROM beers JOIN breweries USING (brewery_id) WHERE type = ? ORDER BY beer_name;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, type);
        while (results.next()) {
            Beer beer = mapRowToBeer(results);
            beers.add(beer);
        }
        return beers;
    }

    @Override
    public boolean addBeer(int breweryId, String beerName, double abv, String type, String beerDescription) {
        String sql = "INSERT into beers (brewery_id, beer_name, abv, beer_type, beer_description) VALUES (?, ?, ?, ?, ?);";
        return jdbcTemplate.update(sql, breweryId, beerName, abv, type, beerDescription) == 1;
    }

    private Beer mapRowToBeer(SqlRowSet rs) {
        Beer beer = new Beer();
        beer.setBeerId(rs.getInt("beer_id"));
        beer.setBeerName(rs.getString("beer_name"));
        beer.setAbv(rs.getDouble("abv"));
        beer.setType(rs.getString("type"));
        beer.setBeerDescription(rs.getString("description"));
        return beer;
    }


}
