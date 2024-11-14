package com.kata_api.beer.services;

import com.kata_api.beer.entities.Styles;
import com.kata_api.beer.repositories.StyleRepository;
import org.springframework.data.domain.Page;

import java.util.List;

public class StylesServices {
    private final StyleRepository styleRepository;
    public StylesServices(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    public List<Styles> getStyles() {
        return styleRepository.findAll();
    }

    public Styles getStyleById(int id) {
        return styleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Style not found"));
    }
}
