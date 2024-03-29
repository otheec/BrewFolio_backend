package com.example.BrewFofolio.repository;

import com.example.BrewFofolio.model.Beer;
import com.example.BrewFofolio.model.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {
    List<Beer> findAllByBrewery(Brewery brewery);
    List<Beer> findAllByOrderByName();
}
