package com.example.BrewFofolio.service;

import com.example.BrewFofolio.model.Beer;
import com.example.BrewFofolio.model.Brewery;

import java.util.List;

public interface BeerService {
    Beer createBeer(Beer beer);
    List<Beer> getAllBeers();
    Beer getBeerById(long id);
    List<Beer> getAllByBrewery(Brewery brewery);
    List<Beer> getAllByOrderByName();
}
