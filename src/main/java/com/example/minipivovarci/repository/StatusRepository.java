package com.example.minipivovarci.repository;

import com.example.minipivovarci.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findAllByStatusEquals(String name);
}
