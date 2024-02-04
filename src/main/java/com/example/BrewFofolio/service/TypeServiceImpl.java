package com.example.BrewFofolio.service;

import com.example.BrewFofolio.model.Type;
import com.example.BrewFofolio.model.dummy.TypeDummy;
import com.example.BrewFofolio.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService{

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public Type createType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    @Override
    public Type getTypeById(long id) {
        return typeRepository.findById(id).orElse(null);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findAllByTypeEquals(name);
    }

    @Override
    public Type handleTypeDummy(TypeDummy typeDummy) {
        if (getTypeByName(typeDummy.getType()) == null) {
            return createType(new Type(typeDummy.getType()));
        } else {
            return getTypeByName(typeDummy.getType());
        }
    }
}
