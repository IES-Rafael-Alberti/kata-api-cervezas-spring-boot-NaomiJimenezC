package com.kata_api.beer.services;

import com.kata_api.beer.entities.Styles;
import com.kata_api.beer.repositories.StyleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StylesServices {
    private final StyleRepository styleRepository;
    public StylesServices(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    public Page<Styles> getStyles(Pageable pageable) {
        return styleRepository.findAll(pageable);
    }

    public Styles getStyleById(int id) {
        return styleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Style not found"));
    }
}
