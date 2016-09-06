package com.metall_a.orders_manager.app.model.entity;

import com.metall_a.orders_manager.app.model.entity.base.User;
import com.metall_a.orders_manager.app.model.entity.enums.Position;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Contains unit-tests to check functionality of {@link User} class
 *
 * @author Kononenko Vasiliy
 */
public class UserTest {
    @Test(expected = NullPointerException.class)
    public void setup() {
        User user = User.builder().id(1).name("Jon").lastName("Morrison").email("jonmorrison@gmail.com")
                .userName("morrison").password("123456").position(Position.DIRECTOR).build();
        assertTrue(false);
    }
/*
    @Test
    public void testAddValidStationSuccess() {
        Station station = user.addStation(TransportType.AUTO);

        assertTrue(containsStation(user, station));
        assertEquals(user, station.getCity());
    }*/
/*
    @Test(expected = NullPointerException.class)
    public void testAddStationNullTransportTypeFailure() {
        user.addStation(null);

        assertTrue(false);
    }*/

    /*@Test
    public void testRemoveStationSuccess() {
        Station station = user.addStation(TransportType.AVIA);

        user.removeStation(station);

        assertTrue(user.getStations().isEmpty());
    }*/

    /*@Test(expected = NullPointerException.class)
    public void testRemoveNullStationFailure() {
        user.removeStation(null);

        assertTrue(false);
    }*/

    /*private boolean containsStation(City city, Station station) {
        return city.getStations().contains(station);
    }*/
}