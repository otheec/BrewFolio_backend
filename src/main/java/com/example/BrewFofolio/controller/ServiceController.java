package com.example.BrewFofolio.controller;

import com.example.BrewFofolio.components.Fetcher;
import com.example.BrewFofolio.model.dummy.BreweryDummy;
import com.example.BrewFofolio.service.BreweryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class ServiceController {

    @Autowired
    private BreweryService breweryService;

    @Autowired
    private Fetcher fetcher;

    @GetMapping
    public int upload() throws Exception {
        fetcher.getBreweryDummiesFromExcel();
        int i = 0;
        for (BreweryDummy breweryDummy: fetcher.getBreweries()) {
            breweryService.createBrewery(breweryDummy);
            i++;
        }
        return i;
    }
}
