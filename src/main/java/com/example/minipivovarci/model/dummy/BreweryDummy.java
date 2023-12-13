package com.example.minipivovarci.model.dummy;

import java.util.ArrayList;

public class BreweryDummy {
    private TypeDummy typeDummy;

    private NameDummy name;

    private PlaceDummy place;

    private StatusDummy statusDummy;

    private String years;

    private String webpage;

    private String facebook;

    private ArrayList<BeerDummy> beers;

    private Boolean visited;

    public BreweryDummy(TypeDummy typeDummy, NameDummy name, PlaceDummy place, StatusDummy statusDummy, String years, String webpage, String facebook, Boolean visited) {
        this.typeDummy = typeDummy;
        this.name = name;
        this.place = place;
        this.statusDummy = statusDummy;
        this.years = years;
        this.webpage = webpage;
        this.facebook = facebook;
        this.beers = new ArrayList<>();
        this.visited = visited;
    }

    public BreweryDummy() {
        this.beers = new ArrayList<>();
    }

    public TypeDummy getType() {
        return typeDummy;
    }

    public void setType(TypeDummy typeDummy) {
        this.typeDummy = typeDummy;
    }

    public NameDummy getName() {
        return name;
    }

    public void setName(NameDummy name) {
        this.name = name;
    }

    public PlaceDummy getPlace() {
        return place;
    }

    public void setPlace(PlaceDummy place) {
        this.place = place;
    }

    public StatusDummy getStatus() {
        return statusDummy;
    }

    public void setStatus(StatusDummy statusDummy) {
        this.statusDummy = statusDummy;
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

    public ArrayList<BeerDummy> getBeers() {
        return beers;
    }

    public void setBeers(ArrayList<BeerDummy> beers) {
        this.beers = beers;
    }

    public void addBeer(BeerDummy beerDummy) {
        beers.add(beerDummy);
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "BreweryDummy{" +
                "typeDummy=" + typeDummy +
                ", name=" + name +
                ", place=" + place +
                ", statusDummy=" + statusDummy +
                ", years='" + years + '\'' +
                ", webpage='" + webpage + '\'' +
                ", facebook='" + facebook + '\'' +
                ", beers=" + beers +
                ", visited=" + visited +
                '}';
    }
}
