package com.example.minipivovarci.service;

import com.example.minipivovarci.model.Name;

import java.util.List;

public interface NameService {
    Name createName(Name name);
    List<Name> getAllNames();
    Name getNameById(long id);
}
