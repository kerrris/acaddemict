package com.realdolmen.course;

import com.realdolmen.course.domain.Flight;
import com.realdolmen.course.domain.Ticket;
import junit.framework.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class TicketPersistenceTicket extends DataSetPersistenceTest {

    @Test
    public void ticketCanBePersisted() {

        Flight flight = new Flight("mlkjkl", new Date(), new Date());

        Ticket t = new Ticket(new BigDecimal(50.0), new Date(), "Brussel", flight);
        entityManager().persist(flight);
        entityManager().persist(t);

        assertTrue(flight.getTickets().contains(t));
        System.out.println(t.getDestination());
        assertNotNull(t.getId());
        entityManager().flush();
    }

    @Test
    public void retrieveTicketById() {

        Ticket t = entityManager().find(Ticket.class, 1);
    }

    @Test
    public void ticketCanBeRemoved() throws Exception {
        Ticket t = entityManager().find(Ticket.class, 1);
        entityManager().remove(t);
        Ticket t2 = entityManager().find(Ticket.class, 1);

        assertNull(t2);
    }

}
