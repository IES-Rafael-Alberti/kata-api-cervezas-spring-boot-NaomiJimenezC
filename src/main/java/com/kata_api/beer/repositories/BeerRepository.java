package com.kata_api.beer.repositories;

import com.kata_api.beer.entities.Beer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Integer> {
    Beer findByName(String name);
    Page<Beer> findByNameContainingIgnoreCase(String name, Pageable pageable);
}