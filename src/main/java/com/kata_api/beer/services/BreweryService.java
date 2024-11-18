package com.kata_api.beer.services;

import com.kata_api.beer.DTO.BreweryDTO;
import com.kata_api.beer.entities.Brewery;
import com.kata_api.beer.repositories.BreweryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class BreweryService {
    private final BreweryRepository breweryRepository;
    public BreweryService(BreweryRepository breweryRepository) {
        this.breweryRepository = breweryRepository;
    }
    public Page<BreweryDTO> getAllBreweries(Pageable pageable) {
        return breweryRepository.findAll(pageable).map(this::convertirABreweryDTO);
    }
    public Brewery getBreweryById(Integer id) {
        return breweryRepository.findById(id).orElse(null);
    }
    private BreweryDTO convertirABreweryDTO(Brewery brewery) {
        BreweryDTO dto = new BreweryDTO();
        dto.setId(brewery.getId());
        dto.setName(brewery.getName() != null ? brewery.getName() : "N/A");
        dto.setAddress1(brewery.getAddress1() != null ? brewery.getAddress1() : "N/A");
        dto.setAddress2(brewery.getAddress2() != null ? brewery.getAddress2() : null);
        dto.setCity(brewery.getCity() != null ? brewery.getCity() : "Unknown City");
        dto.setState(brewery.getState() != null ? brewery.getState() : "Unknown State");
        dto.setCode(brewery.getCode() != null ? brewery.getCode() : null);
        dto.setCountry(brewery.getCountry() != null ? brewery.getCountry() : "Unknown Country");
        dto.setPhone(brewery.getPhone() != null ? brewery.getPhone() : null);
        dto.setWebsite(brewery.getWebsite() != null ? brewery.getWebsite() : null);
        dto.setFilepath(brewery.getFilepath() != null ? brewery.getFilepath() : null);
        dto.setDescript(brewery.getDescript() != null ? brewery.getDescript() : "No description available.");
        dto.setAddUser(brewery.getAddUser() != null ? brewery.getAddUser() : -1);
        dto.setLastMod(brewery.getLastMod() != null ? brewery.getLastMod() : Instant.now());

        return dto;
    }


}
