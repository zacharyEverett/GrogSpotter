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
    protected static final Brewery BREWERY_1 = new Brewery(1, "Mindful", "3759 Library Rd", "Pittsburgh", "PA", "15234", LocalTime.parse("11:00:00"), LocalTime.parse("00:00:00"), "Mindful brewery is a new hot spot in the Castle Shannon borough of Pittsburgh, crafting their own beers. They also have a renowned menu of pub food with a restaurant open to all ages", true);
    protected static final Brewery BREWERY_2 = new Brewery(2,"Kyle Beer Co", "111 Beer Lane", "Beertown", "PA", "15228", LocalTime.parse("00:00:00"), LocalTime.parse("00:00:00"), "The south hills premier location for locally crafted beers", true);
    private JdbcBreweryDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcBreweryDao(jdbcTemplate);
    }
    @Test
    public void findAllBreweriesTest(){
        List<Brewery> breweries = new ArrayList<>();
        breweries = sut.findAll();
        Assert.assertEquals(2, breweries.size());
    }
    @Test
    public void getBreweryByIdTest(){
        Brewery actual = sut.getBreweryById(1);
        Brewery expected = BREWERY_1;
        assertBreweriesMatch(actual, expected);
        Assert.assertEquals(actual.getBreweryID(), expected.getBreweryID());
        Assert.assertEquals(actual.getBreweryName(), expected.getBreweryName());
        Assert.assertEquals(actual.getStreetAddress(), expected.getStreetAddress());
        Assert.assertEquals(actual.getCity(), expected.getCity());
        Assert.assertEquals(actual.getStateAbv(), expected.getStateAbv());
        Assert.assertEquals(actual.getZip(), expected.getZip());
        Assert.assertTrue(actual.isActive());
        Assert.assertEquals(actual.getHistory(), expected.getHistory());
    }
    @Test
    public void getBreweryByNameTest() {
        Brewery actual = sut.getBreweryByName("Mindful");
        Brewery expected = BREWERY_1;
        Assert.assertEquals(actual.getBreweryID(), expected.getBreweryID());
        Assert.assertEquals(actual.getBreweryName(), expected.getBreweryName());
        Assert.assertEquals(actual.getStreetAddress(), expected.getStreetAddress());
        Assert.assertTrue(actual.isActive());
        Assert.assertEquals(actual.getHistory(), expected.getHistory());
    }
    @Test
    public void findBreweryIdByNameTest() {
        int breweryId = sut.findBreweryIdByName("Mindful");
        int expected = 1;
        Assert.assertEquals(breweryId, expected);
    }
    @Test
    public void addBreweryAddsObject() {
        Brewery newBrewery = new Brewery(3, "NEW", "111", "PGH", "PA", "15228", LocalTime.of(22, 00), LocalTime.of(11, 00), "My New Brewery Rocks", true);

    }


    public void assertBreweriesMatch(Brewery expected, Brewery actual) {
        Assert.assertEquals(expected.getBreweryID(), actual.getBreweryID());
        Assert.assertEquals(expected.getBreweryName(), actual.getBreweryName());
        Assert.assertEquals(expected.getStreetAddress(), actual.getStreetAddress());
        Assert.assertEquals(expected.getCity(), actual.getCity());
        Assert.assertEquals(expected.getStateAbv(), actual.getStateAbv());
        Assert.assertEquals(expected.getZip(), actual.getZip());
        Assert.assertEquals(expected.getTimeOpen(), actual.getTimeOpen());
        Assert.assertEquals(expected.getTimeClosed(), actual.getTimeClosed());
        Assert.assertEquals(expected.getHistory(), actual.getHistory());
        Assert.assertEquals(expected.isActive(), actual.isActive());
    }
}
