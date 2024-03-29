package com.example.BrewFofolio.service;

import com.example.BrewFofolio.model.*;
import com.example.BrewFofolio.model.dummy.BeerDummy;
import com.example.BrewFofolio.model.dummy.BreweryDummy;
import com.example.BrewFofolio.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreweryServiceImpl implements BreweryService{

    @Autowired
    BreweryRepository breweryRepository;
    @Autowired
    BeerRepository beerRepository;
    @Autowired
    NameRepository nameRepository;

    @Autowired
    TypeService typeService;
    @Autowired
    StatusService statusService;


    @Override
    public Brewery createBrewery(Brewery brewery) {
        return breweryRepository.save(brewery);
    }

    @Override
    public List<Brewery> getAllBreweries() {
        return breweryRepository.findAll();
    }

    @Override
    public Brewery createBrewery(BreweryDummy breweryDummy) {
        Type type = typeService.handleTypeDummy(breweryDummy.getType());
        Name name = nameRepository.save(new Name(breweryDummy.getName().getShortName(), breweryDummy.getName().getLongName()));
        Status status = statusService.handleStatusDummy(breweryDummy.getStatus());
        String years = breweryDummy.getYears();
        String webpage = breweryDummy.getWebpage();
        String facebook = breweryDummy.getFacebook();
        boolean visited = breweryDummy.getVisited();

        Brewery brewery = new Brewery(type, name, status, years, webpage, facebook, visited);

        for(BeerDummy beerDummy: breweryDummy.getBeers()) {
            Beer beer = new Beer(beerDummy.getName(), brewery);
            beer.setBrewery(brewery);
            brewery.addBeer(beer);
        }

        Brewery ret = breweryRepository.save(brewery);

        for (Beer beer: ret.getBeers()) {
            beerRepository.save(beer);
        }

        return ret;
    }

    @Override
    public List<Brewery> getAllByType(Type type) {
        return breweryRepository.getAllByType(type);
    }

    @Override
    public List<Brewery> getAllByStatus(Status status) {
        return breweryRepository.getAllByStatus(status);
    }

    @Override
    public List<Brewery> getBreweriesByStatusIdsAndTypesIds(List<Long> statusIds, List<Long> typeIds) {
        return breweryRepository.findByStatus_IdInAndType_IdIn(statusIds, typeIds);
    }

    @Override
    public List<Brewery> getBreweriesPageByStatusIdsAndTypeIdsPageable(List<Long> statusIds, List<Long> typeIds, Pageable pageable) {
        return breweryRepository.findByStatus_IdInAndType_IdIn(statusIds, typeIds, pageable);
    }

    @Override
    public long getCountBreweriesByStatusIdsAndTypeIds(List<Long> statusIds, List<Long> typeIds) {
        return breweryRepository.countByStatus_IdInAndType_IdIn(statusIds, typeIds);
    }
}
