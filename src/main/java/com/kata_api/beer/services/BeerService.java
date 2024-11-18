package com.kata_api.beer.services;

import com.kata_api.beer.DTO.BeerDTO;
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

    public Page<BeerDTO> listarCervezas(Pageable pageable) {

        return beerRepository.findAll(pageable).map(this::convertirABeerDTO);
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

    private BeerDTO convertirABeerDTO(Beer cerveza) {
        BeerDTO dto = new BeerDTO();
        dto.setId(cerveza.getId());
        dto.setName(cerveza.getName());
        dto.setAbv(cerveza.getAbv());
        dto.setIbu(cerveza.getIbu());
        dto.setSrm(cerveza.getSrm());
        dto.setUpc(cerveza.getUpc());
        dto.setFilepath(cerveza.getFilepath());
        dto.setDescript(cerveza.getDescript());
        dto.setLastMod(cerveza.getLastMod());

        // Verificaciones para evitar NullPointerException
        dto.setBreweryId(cerveza.getBrewery() != null ? cerveza.getBrewery().getId() : null);
        dto.setStyleId(cerveza.getStyle() != null ? cerveza.getStyle().getId() : null);
        dto.setCategoryId(cerveza.getCategory() != null ? cerveza.getCategory().getId() : null);

        return dto;
    }
}
