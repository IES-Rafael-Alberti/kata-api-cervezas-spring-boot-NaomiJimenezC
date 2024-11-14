package com.kata_api.beer.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private Float abv;
    private Float ibu;
    private Float srm;
    private Integer upc;
    private String filepath;

    @Lob
    private String descript;

    private Integer addUser;
    private Instant lastMod;

    @ManyToOne
    @JoinColumn(name = "brewery_id")
    private Brewery brewery;

    @ManyToOne
    @JoinColumn(name = "style_id")
    private Styles style;

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Category category;
}
