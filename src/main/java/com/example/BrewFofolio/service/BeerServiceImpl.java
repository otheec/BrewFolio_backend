package com.example.BrewFofolio.service;

import com.example.BrewFofolio.model.Beer;
import com.example.BrewFofolio.model.Brewery;
import com.example.BrewFofolio.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeerServiceImpl implements BeerService{

    @Autowired
    BeerRepository beerRepository;

    @Override
    public Beer createBeer(Beer beer) {
        return beerRepository.save(beer);
    }

    @Override
    public List<Beer> getAllBeers() {
        return beerRepository.findAll();
    }

    @Override
    public Beer getBeerById(long id) {
        return beerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Beer> getAllByBrewery(Brewery brewery) {
        return beerRepository.findAllByBrewery(brewery);
    }

    @Override
    public List<Beer> getAllByOrderByName() {
        return beerRepository.findAllByOrderByName();
    }
}
