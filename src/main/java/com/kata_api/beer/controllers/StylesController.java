package com.kata_api.beer.controllers;

import com.kata_api.beer.entities.Styles;
import com.kata_api.beer.services.StylesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/styles")
@CrossOrigin(origins = "http://example.com")
public class StylesController {
    private final StylesServices stylesServices;

    @Autowired
    public StylesController(StylesServices stylesRepository) {
        this.stylesServices = stylesRepository;
    }

    @GetMapping
    @CrossOrigin(origins = "http://example.com")
    public ResponseEntity<Page<Styles>> listarEstilos(Pageable pageable) {
        Page<Styles> styles = stylesServices.getStyles(pageable);
        return ResponseEntity.ok(styles);
    }

    @GetMapping("/style/{id}")
    public ResponseEntity<Styles> buscarPorId(@PathVariable int id) {
        Styles style = stylesServices.getStyleById(id);
        return ResponseEntity.ok(style);
    }
}
