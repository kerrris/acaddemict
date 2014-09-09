package com.realdolmen.course.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Ticket {
    @Id
    @GeneratedValue
    private Integer id;
    private BigDecimal price;
    private Date dateOfDeparture;
    private String destination;

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


}
