package com.example.minipivovarci.model;

import jakarta.persistence.*;

@Entity
@Table(name = "names")
public class Name {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String shortName;
    private String longName;

    public Name(String shortName, String longName) {
        this.shortName = shortName;
        this.longName = longName;
    }

    public Name() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }
}
