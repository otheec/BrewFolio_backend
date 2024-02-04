package com.example.BrewFofolio.service;

import com.example.BrewFofolio.model.Status;
import com.example.BrewFofolio.model.dummy.StatusDummy;

import java.util.List;

public interface StatusService {
    Status createStatus(Status status);
    List<Status> getAllStatuses();
    Status getStatusById(long id);
    Status getStatusByName(String name);
    Status handleStatusDummy(StatusDummy statusDummy);
}
