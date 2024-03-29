package com.realdolmen.course.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
public class Passenger {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, updatable = false)
    private String ssn;
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;
    private int frequentFlyerMiles;
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    //transient wil zeggen dat het niet in de database terecht komt
    @Transient
    private int age;
    @Column(nullable = false)
    private PassengerType passengerType;
    @Temporal(TemporalType.DATE)
    private Date lastFlight;
    @Temporal(TemporalType.DATE)
    private Date dateLastUpdated;
    //dit is niet de owner side, ticket wel.
    @OneToMany(mappedBy = "passenger")
    List<Ticket> tickets = new ArrayList<Ticket>();


    @Embedded
    private Address address;

    protected Passenger() {

    }

    public Passenger(String ssn, String firstName, String lastName, int frequentFlyerMiles, Date dateOfBirth, PassengerType passengerType, Date lastFlight) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.frequentFlyerMiles = frequentFlyerMiles;
        this.dateOfBirth = dateOfBirth;
        this.passengerType = passengerType;
        this.lastFlight = lastFlight;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() {

        Calendar dob = Calendar.getInstance();
        dob.setTime(dateOfBirth);
        Calendar today = Calendar.getInstance();
        age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) <= dob.get(Calendar.DAY_OF_YEAR))
            age--;
        return age;

    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public Date getLastFlight() {
        return lastFlight;
    }

    public Long getId() {
        return id;
    }

    public String getSsn() {
        return ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public Date getDateLastUpdated() {
        return dateLastUpdated;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public Address getAddress() {
        return address;
    }

    //dit zorgt ervoor dat deze methode wordt uitgevoerd vlak voor de update en persist
    @PrePersist
    @PreUpdate
    public void beforePersist() {
        this.dateLastUpdated = new Date();
    }
}
