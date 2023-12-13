package com.example.minipivovarci.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "beers")
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "brewery_id")
    private Brewery brewery;

    public Beer(long id, String name, Brewery brewery) {
        this.id = id;
        this.name = name;
        this.brewery = brewery;
    }

    public Beer(String name, Brewery brewery) {
        this.name = name;
        this.brewery = brewery;
    }

    public Beer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brewery getBrewery() {
        return brewery;
    }

    public void setBrewery(Brewery brewery) {
        this.brewery = brewery;
    }
}
