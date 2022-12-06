package com.techelevator.dao;

import com.techelevator.model.User;
import com.techelevator.model.app.Beer;
import com.techelevator.model.app.Brewery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Array;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class JdbcBreweriesDaoTests extends BaseDaoTests{
    protected static final Brewery BREWERY_1 = new Brewery(1, "Mindful", "3759 Library Rd, Pittsburgh, PA 15234", LocalTime.parse("11:00:00"), LocalTime.parse("00:00:00"), "Mindful brewery is a new hot spot in the Castle Shannon borough of Pittsburgh, crafting their own beers. They also have a renowned menu of pub food with a restaurant open to all ages", true);
    protected static final Brewery BREWERY_2 = new Brewery(2,"Kyle Beer Co", "111 Beer Lane, Beertown, PA 15228", LocalTime.parse("00:00:00"), LocalTime.parse("00:00:00"), "The south hills premier location for locally crafted beers", true);
    private JdbcBreweriesDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcBreweriesDao(jdbcTemplate);
    }
    @Test
    public void findAllBreweriesTest(){
        List<Brewery> breweries = new ArrayList<>();
        breweries = sut.findAll();
        Assert.assertEquals(2, breweries.size());
    }
    @Test
    public void getBreweryByIdTest(int breweryId){
        Brewery actual = sut.getBreweryById(1);
        Brewery expected = BREWERY_1;
    }


    public void assertBeersMatch(Brewery expected, Brewery actual) {
        Assert.assertEquals(expected.getBreweryID(), actual.getBreweryID());
        Assert.assertEquals(expected.getBreweryName(), actual.getBreweryName());
        Assert.assertEquals(expected.getBreweryAddress(), actual.getBreweryAddress());
        Assert.assertEquals(expected.getTimeOpen(), actual.getTimeOpen());
        Assert.assertEquals(expected.getTimeClosed(), actual.getTimeClosed());
        Assert.assertEquals(expected.getHistory(), actual.getHistory());
        Assert.assertEquals(expected.isActive(), actual.isActive());
    }
}
