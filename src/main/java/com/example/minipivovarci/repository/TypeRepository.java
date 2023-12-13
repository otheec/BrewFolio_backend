package com.example.minipivovarci.repository;

import com.example.minipivovarci.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findAllByTypeEquals(String name);
}
