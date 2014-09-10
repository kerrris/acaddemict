package com.realdolmen.course;

import com.realdolmen.course.domain.Flight;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertNotNull;

public class FlightPersistenceTest extends DataSetPersistenceTest {

    @Test
    public void flightCanBePersisted() throws Exception{
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date departure = formatter.parse("2014-9-20");
        Date arrival = formatter.parse("2014-10-1");
        Flight flight = new Flight("FKK-111", departure,arrival);
        entityManager().persist(flight);
        assertNotNull(flight.getId());

    }

}
