package com.kata_api.beer.services;

import com.kata_api.beer.entities.Beer;
import com.kata_api.beer.repositories.BeerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BeerService {
    private final BeerRepository beerRepository;
    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public Page<Beer> listarCervezas(Pageable pageable) {
        return beerRepository.findAll(pageable);
    }

    public Beer buscarPorId(Integer id) {
        return beerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Libro no encontrado con id " + id)
        );
    }

    public Beer crearCerveza(Beer newBeer){
        return beerRepository.save(newBeer);
    }

    public Beer editarCerveza(Integer id, Beer newBeer){
        return beerRepository.findById(id).map(beer -> {
            beer.setName(newBeer.getName());
            beer.setAbv(newBeer.getAbv());
            beer.setBrewery(newBeer.getBrewery());
            beer.setCategory(newBeer.getCategory());
            beer.setDescript(newBeer.getDescript());
            beer.setIbu(newBeer.getIbu());
            beer.setSrm(newBeer.getSrm());
            beer.setUpc(newBeer.getUpc());
            beer.setFilepath(newBeer.getFilepath());
            beer.setStyle(newBeer.getStyle());
            beer.setAddUser(newBeer.getAddUser());
            beer.setLastMod(newBeer.getLastMod());

            return beerRepository.save(beer);
        }).orElseThrow(() -> new RuntimeException("Cerveza no encontrada con id " + id));
    }

    public void eliminarCerveza(Integer id) {
        if (beerRepository.existsById(id)) {
            beerRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cerveza no encontrada con id " + id);
        }
    }
}
