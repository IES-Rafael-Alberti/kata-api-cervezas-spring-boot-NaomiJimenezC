package com.kata_api.beer.services;

import com.kata_api.beer.DTO.StylesDTO;
import com.kata_api.beer.entities.Styles;
import com.kata_api.beer.repositories.StyleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StylesServices {
    private final StyleRepository styleRepository;
    public StylesServices(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    public Page<StylesDTO> getStyles(Pageable pageable) {
        return styleRepository.findAll(pageable).map(this::convertirADto);
    }

    public Styles getStyleById(int id) {
        return styleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Style not found"));
    }

    private StylesDTO convertirADto(Styles styles) {
        StylesDTO stylesDTO = new StylesDTO();
        stylesDTO.setId(styles.getId());
        stylesDTO.setStyleName(styles.getStyleName());
        stylesDTO.setCatId(styles.getCatId());
        stylesDTO.setLastMod(styles.getLastMod());

        return stylesDTO;
    }
}
