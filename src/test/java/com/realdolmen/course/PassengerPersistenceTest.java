package com.realdolmen.course;


import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.PassengerType;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PassengerPersistenceTest extends PersistenceTest {

    @Test
    public void passengerCanBePersisted() throws Exception{
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date d = formatter.parse("1988-10-18");
        Date d2 = formatter.parse("2014-10-18");
        Passenger p = new Passenger("654564","Keris", "Van Engeland", 50, d, PassengerType.OCCASIONAL,d2 );
        entityManager().persist(p);
        assertEquals(25, p.getAge());
        assertNotNull(p.getId());

    }


}
