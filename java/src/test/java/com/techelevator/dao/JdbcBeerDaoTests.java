package com.techelevator.dao;

import com.techelevator.model.User;
import com.techelevator.model.app.Beer;
import com.techelevator.model.app.Brewery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class JdbcBeerDaoTests extends BaseDaoTests{
    protected static final User USER_1 = new User(1, "user1", "user1", "ROLE_USER");
    protected static final User USER_2 = new User(2, "user2", "user2", "ROLE_USER");
    private static final User USER_3 = new User(3, "user3", "user3", "ROLE_USER");
    protected static final Beer BEER_1 = new Beer(1, 1, "88 rabbits", 8, "Adjunct Lager", "Named for the famous route 88 that Mindful resides on");
    protected static final Beer BEER_2 = new Beer(2, 2, "Kyles Blonde Lager", 12.1, "American Lager", "Flagship beer from the flagship brewery in Western PA");
    private static final Beer BEER_3 = new Beer(3, 2, "TomA Porter", 12.5, "Porter", "Dark and strong porter created by the infamous Tom Anderson");

    private JdbcBeerDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcBeerDao(jdbcTemplate);
    }

    @Test
    public void getByIdTestHappyPath() {
        Beer actual = sut.getById(1);
        Beer expected = BEER_1;
        assertBeersMatch(actual, expected);
//        Assert.assertEquals(expected.getAbv(), actual.getAbv(), .1);
//        Assert.assertEquals(expected.getBeerId(), actual.getBeerId());
//        Assert.assertEquals(expected.getBeerName(), actual.getBeerName());
//        Assert.assertEquals(expected.getBreweryId(), actual.getBreweryId());
//        Assert.assertEquals(expected.getBeerDescription(), actual.getBeerDescription());

    }

    @Test
    public void getAllBeersTest() {
        List<Beer> beers = new ArrayList<>();
        beers = sut.getAll();
        int expected = 3;
        int actual = beers.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getByBreweryIdListLengthOne() {
        List<Beer> beers = new ArrayList<>();
        beers = sut.getByBreweryId(1);
        int expected = 1;
        Assert.assertEquals(expected, beers.size());
    }
    @Test
    public void getByBreweryIdListLengthGreaterThanOne(){
        List<Beer> beers = new ArrayList<>();
        beers = sut.getByBreweryId(2);
        int expected = 2;
        Assert.assertEquals(expected, beers.size());
    }
    @Test
    public void getByBreweryIdListCheckWholeObject(){
        List<Beer> beers = new ArrayList<>();
        beers = sut.getByBreweryId(2);
        Beer expected = BEER_2;
        assertBeersMatch(expected, beers.get(0));
    }
    @Test
    public void getByAbvTest() {
        List<Beer> beers = new ArrayList<>();
        beers = sut.getByAbv(5.0);
        int expected = 3;
        Assert.assertEquals(expected, beers.size());
    }
    @Test
    public void testingTheTestClass() {
        assertBeersMatch(BEER_1, BEER_1);
    }

    public void assertBeersMatch(Beer expected, Beer actual) {
        Assert.assertEquals(expected.getBeerId(), actual.getBeerId());
        Assert.assertEquals(expected.getBreweryId(), actual.getBreweryId());
        Assert.assertEquals(expected.getBeerName(), actual.getBeerName());
        Assert.assertEquals(expected.getAbv(), actual.getAbv(), .1);
        Assert.assertEquals(expected.getType(), actual.getType());
        Assert.assertEquals(expected.getBeerDescription(), actual.getBeerDescription());
    }
}
