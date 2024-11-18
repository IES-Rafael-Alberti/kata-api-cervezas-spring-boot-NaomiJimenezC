package com.kata_api.beer.DTO;

import lombok.Data;

import java.time.Instant;

@Data
public class BreweryDTO {
    private Integer id;
    private String name;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String code;
    private String country;
    private String phone;
    private String website;
    private String filepath;
    private String descript;
    private Integer addUser;
    private Instant lastMod;
}
