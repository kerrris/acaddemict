package com.realdolmen.course.domain;

import javax.persistence.*;

@Entity
public class Book {
    public static enum Genre{
        FANTASY, DRAMA, THRILLER, BIOGRAPHY
    }
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    @Basic(fetch = FetchType.LAZY)
    private byte[] picture;


    //Dit gebruik je als ge een enum gebruikt. Ordinal zorgt ervoor dat in dit geval FANTASY als 0 wordt opgeslagen.
    //Het is dus gevaarlijk wanneer je de enum waarde van plaats verandert.
    //String is daarom mss beter, maar gebruikt meer storage
    @Enumerated(EnumType.STRING)
    private Genre genre;
    protected Book(){};

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
