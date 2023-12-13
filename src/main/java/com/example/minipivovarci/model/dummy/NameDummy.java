package com.example.minipivovarci.model.dummy;

public class NameDummy {
    private String shortName;
    private String longName;

    public NameDummy(String shortName, String longName) {
        this.shortName = shortName;
        this.longName = longName;
    }

    public NameDummy() {
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    @Override
    public String toString() {
        return "NameDummy{" +
                "shortName='" + shortName + '\'' +
                ", longName='" + longName + '\'' +
                '}';
    }
}
