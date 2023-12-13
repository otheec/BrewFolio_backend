package com.example.minipivovarci.controller;

import com.example.minipivovarci.model.Beer;
import com.example.minipivovarci.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/beer")
@CrossOrigin("http://localhost:3000")
public class BeerController {

    @Autowired
    BeerService beerService;

    @GetMapping
    public List<Beer> getAllBeers() {
        return beerService.getAllBeers();
    }

    @GetMapping("/allByName")
    public List<Beer> getAllByOrderByName() {
        return beerService.getAllByOrderByName();
    }
}
