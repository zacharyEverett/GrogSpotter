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
    public List<Beer> getAll() {
        List<Beer> beers = new ArrayList<>();
        String sql = "SELECT beer_name, brewery_name, abv, beer_type, beer_description " +
                "FROM beers JOIN breweries USING (brewery_id) ORDER BY beer_name; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Beer beer = mapRowToBeer(results);
            beers.add(beer);
        }
        return beers;
    }

    @Override
    public List<Beer> getByBreweryId() {
        List<Beer> beers = new ArrayList<>();
        String sql = "SELECT beer_name, brewery_name, abv, beer_type, beer_description " +
                "FROM beers JOIN breweries USING (brewery_id) WHERE brewery_id = ? ORDER BY beer_name;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Beer beer = mapRowToBeer(results);
            beers.add(beer);
        }
        return beers;
    }

    @Override
    public List<Beer> getByAbv() {
        return null;
    }

    @Override
    public List<Beer> getByType() {
        return null;
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
