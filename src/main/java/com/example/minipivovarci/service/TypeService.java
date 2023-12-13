package com.example.minipivovarci.service;

import com.example.minipivovarci.model.Type;
import com.example.minipivovarci.model.dummy.TypeDummy;

import java.util.List;

public interface TypeService {
    Type createType(Type type);
    List<Type> getAllTypes();
    Type getTypeById(long id);
    Type getTypeByName(String name);
    Type handleTypeDummy(TypeDummy typeDummy);
}
