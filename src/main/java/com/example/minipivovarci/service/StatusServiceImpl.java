package com.example.minipivovarci.service;

import com.example.minipivovarci.model.Status;
import com.example.minipivovarci.model.dummy.StatusDummy;
import com.example.minipivovarci.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService{

    @Autowired
    StatusRepository statusRepository;

    @Override
    public Status createStatus(Status status) {
        return statusRepository.save(status);
    }

    @Override
    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

    @Override
    public Status getStatusById(long id) {
        return statusRepository.findById(id).orElse(null);
    }

    @Override
    public Status getStatusByName(String name) {
        return statusRepository.findAllByStatusEquals(name);
    }

    @Override
    public Status handleStatusDummy(StatusDummy statusDummy) {
        if (getStatusByName(statusDummy.getStatus()) == null) {
            return createStatus(new Status(statusDummy.getStatus()));
        } else {
            return getStatusByName(statusDummy.getStatus());
        }
    }
}
