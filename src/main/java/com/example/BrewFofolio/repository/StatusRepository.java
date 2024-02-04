package com.example.BrewFofolio.repository;

import com.example.BrewFofolio.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findAllByStatusEquals(String name);
}
