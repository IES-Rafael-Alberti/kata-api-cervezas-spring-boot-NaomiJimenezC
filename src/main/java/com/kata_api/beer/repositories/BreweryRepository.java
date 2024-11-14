package com.kata_api.beer.repositories;

import com.kata_api.beer.entities.Brewery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreweryRepository extends JpaRepository<Brewery, Integer> {
     Brewery findByBreweryId(long breweryId);
     Page<Brewery> findBreweriesByNameContainingIgnoreCase(String breweryName);
     Page<Brewery>findBreweriesByCityContainingIgnoreCase(String city, Pageable pageable);
}
