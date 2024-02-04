package com.example.BrewFofolio.service;

import com.example.BrewFofolio.model.Brewery;
import com.example.BrewFofolio.model.Status;
import com.example.BrewFofolio.model.Type;
import com.example.BrewFofolio.model.dummy.BreweryDummy;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BreweryService {
    Brewery createBrewery(Brewery brewery);
    List<Brewery> getAllBreweries();
    Brewery createBrewery(BreweryDummy breweryDummy);
    List<Brewery> getAllByType(Type type);
    List<Brewery> getAllByStatus(Status status);
    List<Brewery> getBreweriesByStatusIdsAndTypesIds(List<Long> statusIds, List<Long> typeIds);
    List<Brewery> getBreweriesPageByStatusIdsAndTypeIdsPageable(List<Long> statusIds, List<Long> typeIds, Pageable pageable);
    long getCountBreweriesByStatusIdsAndTypeIds(List<Long> statusIds, List<Long> typeIds);
}
