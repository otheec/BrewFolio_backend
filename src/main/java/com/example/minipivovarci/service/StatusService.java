package com.example.minipivovarci.service;

import com.example.minipivovarci.model.Status;
import com.example.minipivovarci.model.dummy.StatusDummy;

import java.util.List;

public interface StatusService {
    Status createStatus(Status status);
    List<Status> getAllStatuses();
    Status getStatusById(long id);
    Status getStatusByName(String name);
    Status handleStatusDummy(StatusDummy statusDummy);
}
