package com.example.BrewFofolio.service;

import com.example.BrewFofolio.model.Name;

import java.util.List;

public interface NameService {
    Name createName(Name name);
    List<Name> getAllNames();
    Name getNameById(long id);
}
