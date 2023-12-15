package com.example.minipivovarci.repository;

import com.example.minipivovarci.model.Brewery;
import com.example.minipivovarci.model.Status;
import com.example.minipivovarci.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreweryRepository extends JpaRepository<Brewery, Long> {
    List<Brewery> getAllByType(Type type);
    List<Brewery> getAllByStatus(Status status);
}
