package com.example.minipivovarci.controller;

import com.example.minipivovarci.model.Type;
import com.example.minipivovarci.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type")
@CrossOrigin("http://localhost:3000")
public class TypeController {

    @Autowired
    TypeService typeService;

    @GetMapping
    public List<Type> getAllTypes() {
        return typeService.getAllTypes();
    }
}
