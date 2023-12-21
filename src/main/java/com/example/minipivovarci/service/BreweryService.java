package com.example.minipivovarci.service;

import com.example.minipivovarci.model.Brewery;
import com.example.minipivovarci.model.Status;
import com.example.minipivovarci.model.Type;
import com.example.minipivovarci.model.dummy.BreweryDummy;
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
