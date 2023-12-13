package com.example.minipivovarci.controller;

import com.example.minipivovarci.model.Brewery;
import com.example.minipivovarci.service.BreweryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brewery")
@CrossOrigin("http://localhost:3000")
public class BreweryController {

    @Autowired
    BreweryService breweryService;

    @GetMapping
    public List<Brewery> getAllBreweries() {
        return breweryService.getAllBreweries();
    }
}
