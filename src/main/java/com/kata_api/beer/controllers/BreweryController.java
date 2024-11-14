package com.kata_api.beer.controllers;

import com.kata_api.beer.entities.Brewery;
import com.kata_api.beer.services.BreweryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/breweries")
@CrossOrigin(origins = "http://example.com")
public class BreweryController {
    private final BreweryService breweryService;

    @Autowired
    public BreweryController(BreweryService breweryRepository) {
        this.breweryService =breweryRepository;
    }

    @GetMapping
    @CrossOrigin(origins = "http://example.com")
    public ResponseEntity<Page<Brewery>> listarCervecerias(Pageable pageable) {
        Page<Brewery> cervecerias = breweryService.getAllBreweries(pageable);
        return ResponseEntity.ok(cervecerias);
    }

    @GetMapping("/brewerie/{id}")
    public ResponseEntity<Brewery> getBreweryById(@PathVariable int id) {
        Brewery brewery = breweryService.getBreweryById(id);
        return ResponseEntity.ok(brewery);
    }


}
