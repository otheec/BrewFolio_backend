package com.example.minipivovarci.repository;

import com.example.minipivovarci.model.Beer;
import com.example.minipivovarci.model.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {
    List<Beer> findAllByBrewery(Brewery brewery);
}
