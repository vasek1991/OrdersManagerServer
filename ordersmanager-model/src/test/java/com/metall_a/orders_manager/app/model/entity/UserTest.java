package com.metall_a.orders_manager.app.model.entity;

import com.metall_a.orders_manager.app.model.entity.person.Account;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Contains unit-tests to check functionality of {@link Account} class
 *
 * @author Kononenko Vasiliy
 */
public class UserTest {
    @Ignore
    @Test(expected = NullPointerException.class)
    public void setup() {
        /*Account user = Account.builder().id(1).name("Jon").lastName("Morrison").email("jonmorrison@gmail.com")
                .accountName("morrison").password("123456").position(Position.DIRECTOR).build();
        */
        assertTrue(false);
    }
/*
    @Test
    public void testAddValidStationSuccess() {
        Station station = person.addStation(TransportType.AUTO);

        assertTrue(containsStation(person, station));
        assertEquals(person, station.getCity());
    }*/
/*
    @Test(expected = NullPointerException.class)
    public void testAddStationNullTransportTypeFailure() {
        person.addStation(null);

        assertTrue(false);
    }*/

    /*@Test
    public void testRemoveStationSuccess() {
        Station station = person.addStation(TransportType.AVIA);

        person.removeStation(station);

        assertTrue(person.getStations().isEmpty());
    }*/

    /*@Test(expected = NullPointerException.class)
    public void testRemoveNullStationFailure() {
        person.removeStation(null);

        assertTrue(false);
    }*/

    /*private boolean containsStation(City city, Station station) {
        return city.getStations().contains(station);
    }*/
}