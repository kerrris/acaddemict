package com.realdolmen.course.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Flight {
    @Id @GeneratedValue
    private Integer id;
    private String number;
    @Temporal(TemporalType.DATE)
    private Date dateOfDeparture;
    @Temporal(TemporalType.DATE)
    private Date dateOfArrival;

    @OneToMany(mappedBy = "flight", fetch=FetchType.EAGER)
    List<Ticket> tickets = new ArrayList<Ticket>();

    public Flight() {
    }

    public Flight(String number, Date dateOfDeparture, Date dateOfArrival) {
        this.number = number;
        this.dateOfDeparture = dateOfDeparture;
        this.dateOfArrival = dateOfArrival;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(Date dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public Date getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(Date dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}
