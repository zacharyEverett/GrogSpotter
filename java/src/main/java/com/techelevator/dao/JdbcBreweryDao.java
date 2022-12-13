package com.techelevator.dao;

import com.techelevator.model.dto.BreweryDto;
import com.techelevator.model.app.Brewery;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBreweryDao implements BreweriesDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcBreweryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*
    Class Author: Kyle P-N.
    Method Author: Zachary M.
    Notes: Methods should be functional, all work with PGAdmin.
         - Creates may need revisited for controller purposes
         - Changed * to specific column names to account for some potential null issues.
         - ATTENTION - line 72 during stand-up.
         + need to include try/catch blocks and exception handling *DEADLINE* Monday
     */

    @Override
    public List<Brewery> findAll() {
        List<Brewery> breweries = new ArrayList<>();
        String sql = "SELECT brewery_id, brewery_name, street_address, city, state_abv, zip, history \n"+
                "FROM breweries \n" +
                "ORDER BY brewery_name;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            Brewery brewery = mapRowToBrewery(results);
            breweries.add(brewery);
        }
        return breweries;
    }

    @Override
    public Brewery getBreweryById(int breweryId) {
        String sql = "SELECT brewery_id, brewery_name, street_address, city, state_abv, zip, time_open, time_closed, history, is_active\n" +
                "FROM breweries WHERE brewery_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryId);
        if(results.next()){
            return mapRowToBrewery(results);
        }else {
            return null;
        }
    }

    @Override
    public Brewery getBreweryByName(String breweryName) {
        String sql = "SELECT brewery_id, brewery_name, street_address, city, state_abv, zip, time_open, time_closed, history, is_active\n" +
                "FROM breweries WHERE brewery_name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryName);
        if(results.next()){
            return mapRowToBrewery(results);
        }else {
            return null;
        }
    }

    @Override
    public int findBreweryIdByName(String breweryName) {
        if (breweryName == null) throw new IllegalArgumentException("Brewery name cannot be null");
        String sql = "SELECT brewery_id FROM breweries WHERE brewery_name = ?;";
        int breweryId;
        try {
            breweryId = jdbcTemplate.queryForObject(sql, int.class, breweryName);
        }catch (EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("Brewery " + breweryName + " was not found.");
        }
        return breweryId;
    }

    @Override
    public List<Brewery> findBreweryByBrewerId(int brewerId){
        List<Brewery> breweryList = new ArrayList<>();
        String sql = "SELECT brewery_id, brewery_name, street_address, city, state_abv, zip, time_open, time_closed, " +
                "history, is_active FROM breweries WHERE brewer_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, brewerId);
        while(results.next()){
            Brewery brewery = mapRowToBrewery(results);
            breweryList.add(brewery);
        }
        return breweryList;
    }

    @Override
    public Brewery addBrewery(BreweryDto brewery) {
        Integer breweryId = 0;
        Brewery brewery1 = new Brewery();
        String sql = "INSERT INTO breweries (brewery_name, street_address, city, state_abv, zip, time_open, time_closed, history, brewer_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)  RETURNING brewery_id;";
        breweryId = jdbcTemplate.queryForObject(sql, Integer.class, brewery.getBreweryName(), brewery.getStreetAddress(), brewery.getCity(), brewery.getStateAbv(), brewery.getZip(), brewery.getTimeOpen(), brewery.getTimeClosed(), brewery.getHistory(), brewery.getBrewer_id());
        brewery1 = getBreweryById(breweryId);
        return brewery1;
    }

    @Override
    public Brewery updateBrewery(BreweryDto brewery){
        String sql = "UPDATE breweries SET brewery_name = ?, street_address = ?, city = ?, stave_abv = ?" +
                "zip = ?, time_open = ?, time_closed = ?, history = ? WHERE brewery_id = ?;";
        Brewery updatedBrewery = new Brewery();
        int breweryId = 0;
        breweryId = jdbcTemplate.update(sql, brewery.getBreweryName(),brewery.getStreetAddress(),brewery.getCity(),
                brewery.getStateAbv(),brewery.getZip(),brewery.getTimeOpen(),brewery.getTimeClosed(),brewery.getHistory(), brewery.getBreweryID());
        updatedBrewery = getBreweryById(breweryId);
        return updatedBrewery;
    }

    private Brewery mapRowToBrewery(SqlRowSet rs) {
        Brewery brewery = new Brewery();
        brewery.setBreweryID(rs.getInt("brewery_id"));
        brewery.setBreweryName(rs.getString("brewery_name"));
        brewery.setStreetAddress(rs.getString("street_address"));
        brewery.setCity(rs.getString("city"));
        brewery.setStateAbv(rs.getString("state_abv"));
        brewery.setZip(rs.getString("zip"));
        brewery.setHistory(rs.getString("history"));
        return brewery;
    }

   
}
