package com.example.minipivovarci.model.dummy;

public class BeerDummy {
    private String name;

    public BeerDummy(String name) {
        this.name = name;
    }

    public BeerDummy() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "BeerDummy{" +
                "name='" + name + '\'' +
                '}';
    }
}
