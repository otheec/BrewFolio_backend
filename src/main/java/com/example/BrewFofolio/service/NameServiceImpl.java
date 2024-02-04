package com.example.BrewFofolio.service;

import com.example.BrewFofolio.model.Name;
import com.example.BrewFofolio.repository.NameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NameServiceImpl implements NameService{
    @Autowired
    NameRepository nameRepository;

    @Override
    public Name createName(Name name) {
        return nameRepository.save(name);
    }

    @Override
    public List<Name> getAllNames() {
        return nameRepository.findAll();
    }

    @Override
    public Name getNameById(long id) {
        return nameRepository.findById(id).orElse(null);
    }
}
