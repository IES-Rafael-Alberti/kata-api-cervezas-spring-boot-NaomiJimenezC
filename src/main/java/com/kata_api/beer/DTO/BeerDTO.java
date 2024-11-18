package com.kata_api.beer.DTO;

import lombok.Data;

import java.time.Instant;

@Data
public class BeerDTO    {
    private Integer id;
    private String name;
    private Float abv;
    private Float ibu;
    private Float srm;
    private Integer upc;
    private String filepath;
    private String descript;
    private Integer addUser;
    private Instant lastMod;

    private Integer breweryId;
    private Integer styleId;
    private Integer categoryId;
}
