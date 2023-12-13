package com.example.minipivovarci.service;

import com.example.minipivovarci.model.Brewery;
import com.example.minipivovarci.model.dummy.BreweryDummy;

import java.util.List;

public interface BreweryService {
    Brewery createBrewery(Brewery brewery);
    List<Brewery> getAllBreweries();
    Brewery createBrewery(BreweryDummy breweryDummy);
}
