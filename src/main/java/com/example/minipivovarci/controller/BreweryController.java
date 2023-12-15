package com.example.minipivovarci.controller;

import com.example.minipivovarci.model.Brewery;
import com.example.minipivovarci.model.Status;
import com.example.minipivovarci.model.Type;
import com.example.minipivovarci.service.BreweryService;
import com.example.minipivovarci.service.StatusService;
import com.example.minipivovarci.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brewery")
@CrossOrigin("http://localhost:3000")
public class BreweryController {

    @Autowired
    BreweryService breweryService;
    @Autowired
    StatusService statusService;
    @Autowired
    TypeService typeService;

    @GetMapping
    public List<Brewery> getAllBreweries() {
        return breweryService.getAllBreweries();
    }

    @GetMapping("/status/{id}")
    public List<Brewery> getBreweryByStatus(@PathVariable long id) {
        Status status = statusService.getStatusById(id);
        return breweryService.getAllByStatus(status);
    }

    @GetMapping("/type/{id}")
    public List<Brewery> getBreweryByType(@PathVariable long id) {
        Type type = typeService.getTypeById(id);
        return breweryService.getAllByType(type);
    }

    @GetMapping("/status-and-type")
    public List<Brewery> getBreweriesByStatusAndType(
            @RequestParam(name = "statusIds") List<Long> statusIds,
            @RequestParam(name = "typeIds") List<Long> typeIds) {
        return breweryService.getBreweriesByStatusIdsAndTypesIds(statusIds, typeIds);
    }
}
