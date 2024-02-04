package com.example.BrewFofolio.service;

import com.example.BrewFofolio.model.Type;
import com.example.BrewFofolio.model.dummy.TypeDummy;

import java.util.List;

public interface TypeService {
    Type createType(Type type);
    List<Type> getAllTypes();
    Type getTypeById(long id);
    Type getTypeByName(String name);
    Type handleTypeDummy(TypeDummy typeDummy);
}
