package com.example.minipivovarci.model;

import jakarta.persistence.*;

@Entity
@Table(name = "statuses")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String status;

    public Status(long id, String status) {
        this.id = id;
        this.status = status;
    }

    public Status(String status) {
        this.status = status;
    }

    public Status() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
