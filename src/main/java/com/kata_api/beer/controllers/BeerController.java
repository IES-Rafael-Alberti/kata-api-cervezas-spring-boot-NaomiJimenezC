package com.kata_api.beer.controllers;

import com.kata_api.beer.entities.Beer;
import com.kata_api.beer.services.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/beers")
@CrossOrigin(origins = "http://example.com")
public class BeerController {
    private BeerService beerService;

    @Autowired
    public BeerController(BeerService beerRepository) {
        this.beerService = beerRepository;
    }

    @GetMapping
    @CrossOrigin(origins = "http://example.com")
    public ResponseEntity<Page<Beer>> listarCervezas(Pageable pageable) {
        Page<Beer> beers = beerService.listarCervezas(pageable);
        return ResponseEntity.ok(beers);
    }

    //obtener una cerveza
    @GetMapping("/{id}")
    public ResponseEntity<Beer> buscarPorId(@PathVariable int id) {
        Beer beer = beerService.buscarPorId(id);
        return ResponseEntity.ok(beer);
    }

    //crear cerveza
    @PostMapping
    public ResponseEntity<Beer> guardarCerveza(@RequestBody Beer beer) {
        Beer nuevaCerveza = beerService.crearCerveza(beer);
        return ResponseEntity.ok(nuevaCerveza);
    }

    //Modificar una cerveza
    @PutMapping("/{id}")
    public ResponseEntity<Beer> actualizarCerveza(@PathVariable int id,
                                                  @RequestBody Beer beerActualizada) {
        Beer beerNueva = beerService.editarCerveza(id, beerActualizada);
        return ResponseEntity.ok(beerNueva);
    }

    //Eliminar una cerveza
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCerveza(@PathVariable int id) {
        beerService.eliminarCerveza(id);
        return ResponseEntity.noContent().build();
    }
}
