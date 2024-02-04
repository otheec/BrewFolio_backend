package com.example.BrewFofolio.repository;

import com.example.BrewFofolio.model.Brewery;
import com.example.BrewFofolio.model.Status;
import com.example.BrewFofolio.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface BreweryRepository extends JpaRepository<Brewery, Long> {
    List<Brewery> getAllByType(Type type);
    List<Brewery> getAllByStatus(Status status);
    List<Brewery> findByStatus_IdInAndType_IdIn(List<Long> statusIds, List<Long> typeIds);
    List<Brewery> findByStatus_IdInAndType_IdIn(List<Long> statusIds, List<Long> typeIds, Pageable pageable);
    long countByStatus_IdInAndType_IdIn(List<Long> statusIds, List<Long> typesIds);
}
