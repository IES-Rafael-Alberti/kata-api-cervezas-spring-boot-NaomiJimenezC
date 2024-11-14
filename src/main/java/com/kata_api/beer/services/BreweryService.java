package com.kata_api.beer.services;

import com.kata_api.beer.entities.Brewery;
import com.kata_api.beer.repositories.BreweryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BreweryService {
    private final BreweryRepository breweryRepository;
    public BreweryService(BreweryRepository breweryRepository) {
        this.breweryRepository = breweryRepository;
    }
    public Page<Brewery> getAllBreweries(Pageable pageable) {
        return breweryRepository.findAll(pageable);
    }
    public Brewery getBreweryById(int id) {
        return breweryRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Brewery not found")
        );
    }
}
