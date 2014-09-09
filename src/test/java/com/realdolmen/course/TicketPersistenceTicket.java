package com.realdolmen.course;

import com.realdolmen.course.domain.Ticket;
import junit.framework.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TicketPersistenceTicket extends PersistenceTest {

    @Test
    public void ticketCanBePersisted(){

        Ticket t = new Ticket(new BigDecimal(50.0), new Date(), "Brussel" );
        entityManager().persist(t);
        System.out.println(t.getDestination());
        assertNotNull(t.getId());
        entityManager().flush();
    }

    @Test
    public void retrieveTicketById(){
        Ticket t = new Ticket(new BigDecimal(50.0), new Date(), "Amsterdam" );
        entityManager().persist(t);
        entityManager().flush();
        Ticket t1 = entityManager().find(Ticket.class, 1);
         System.out.println(t1.getDestination());
        assertNotNull(t1.getDestination());

    }

}
