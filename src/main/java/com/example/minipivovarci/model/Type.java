package com.example.minipivovarci.model;

import jakarta.persistence.*;

@Entity
@Table(name = "types")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String type;

    public Type(long id, String type) {
        this.id = id;
        this.type = type;
    }

    public Type(String type) {
        this.type = type;
    }

    public Type() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
