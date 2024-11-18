package com.kata_api.beer.DTO;

import lombok.Data;

import java.time.Instant;

@Data
public class StylesDTO {
    private Integer id;
    private Integer catId;
    private String styleName;
    private Instant lastMod;
}
