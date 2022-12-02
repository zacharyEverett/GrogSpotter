package com.techelevator.dao;

import com.techelevator.model.app.Brewery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBreweriesDao implements BreweriesDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcBreweriesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Brewery> findAll() {
        List<Brewery> breweries = new ArrayList<>();
        String sql = "select * from breweries;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            Brewery brewery = mapRowToBrewery(results);
            breweries.add(brewery);
        }
        return breweries;
    }

    @Override
    public Brewery getBreweryById(int breweryId) {
        String sql = "SELECT * FROM breweries WHERE brewery_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if(results.next()){
            return mapRowToBrewery(results);
        }else {
            return null;
        }
    }

    @Override
    public Brewery getBreweryByName(String breweryName) {
        String sql = "SELECT * FROM breweries WHERE brewery_name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if(results.next()){
            return mapRowToBrewery(results);
        }else {
            return null;
        }
    }

    @Override
    public int findBreweryIdByName(String breweryName) {
        String sql = "SELECT brewery_id FROM breweries WHERE brewery_name = ?;";
        int breweryId = jdbcTemplate.queryForObject(sql,int.class, breweryName);
        return breweryId;
    }

    @Override
    public boolean create(String breweryName, String breweryAddress) {
        String sql = "INSERT INTO breweries (brewery_name, brewery_address) VALUES (?,?);";
        return jdbcTemplate.update(sql)==1;
    }

    private Brewery mapRowToBrewery(SqlRowSet rs) {
        Brewery brewery = new Brewery();
        brewery.setBreweryID(rs.getInt("brewery_id"));
        brewery.setBreweryName(rs.getString("brewery_name"));
        brewery.setBreweryAddress(rs.getString("brewery_address"));
        return brewery;
    }
}
