package com.realdolmen.course.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
public class Ticket {
    @Id
    @GeneratedValue
    private Integer id;
    private BigDecimal price;
    private Date dateOfDeparture;
    private String destination;
    @ManyToOne
    private Passenger passenger;

    public Ticket() {
    }

    public Ticket(BigDecimal price, Date dateOfDeparture, String destination) {
        this.price = price;
        this.dateOfDeparture = dateOfDeparture;
        this.destination = destination;
    }


    public Integer getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Date getDateOfDeparture() {
        return dateOfDeparture;
    }

    public String getDestination() {
        return destination;
    }

    //TICKET is de owner, dus voor de database wordt enkel naar deze methode gezien, daarom moet je de andere kant ook syncen.
    public void assignPassenger(Passenger passenger){
        this.passenger = passenger;
        //dit syncen doe je zo(kan ook met setter in Passenger, nu was het gewoon friendly gemaakt)
        passenger.tickets.add(this);
    }


}
