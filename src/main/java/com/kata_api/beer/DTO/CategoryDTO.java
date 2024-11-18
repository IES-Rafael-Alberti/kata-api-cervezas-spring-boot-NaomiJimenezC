package com.kata_api.beer.DTO;

import lombok.Data;

import java.time.Instant;

@Data
public class CategoryDTO {
    private Integer id;
    private String catName;
    private Instant lastMod;
}
