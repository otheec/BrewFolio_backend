package com.example.minipivovarci.service;

import com.example.minipivovarci.model.Beer;
import com.example.minipivovarci.model.Brewery;

import java.util.List;

public interface BeerService {
    Beer createBeer(Beer beer);
    List<Beer> getAllBeers();
    Beer getBeerById(long id);
    List<Beer> getAllByBrewery(Brewery brewery);
    List<Beer> getAllByOrderByName();
}
