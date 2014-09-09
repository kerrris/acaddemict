package com.realdolmen.course.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
//deze klasse is gemaakt voor embeddedId en heeft nu geen functie
@Embeddable
public class PassengerId implements Serializable {

    private String ssn;
    private String lastName;

    public PassengerId(){};
    public PassengerId(String ssn, String lastName) {
        this.ssn = ssn;
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
