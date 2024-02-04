package com.example.BrewFofolio.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "breweries")
public class Brewery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "name_id")
    private Name name;

    //place

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    private String years;

    private String webpage;

    private String facebook;

    private boolean visited;

    @OneToMany(mappedBy = "brewery", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Beer> beers;

    public Brewery(Type type, Name name, Status status, String years, String webpage, String facebook, boolean visited) {
        this.type = type;
        this.name = name;
        this.status = status;
        this.years = years;
        this.webpage = webpage;
        this.facebook = facebook;
        this.visited = visited;
        this.beers = new ArrayList<>();
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Brewery() {
        this.beers = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public List<Beer> getBeers() {
        return beers;
    }

    public void setBeers(List<Beer> beers) {
        this.beers = beers;
    }

    public void addBeer(Beer beer) {
        beers.add(beer);
    }
}
