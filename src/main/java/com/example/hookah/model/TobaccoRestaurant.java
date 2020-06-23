package com.example.hookah.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table
public class TobaccoRestaurant {

    @EmbeddedId
    private TobaccoRestaurantIdentity id;

    @MapsId("tobaccoId")
    @ManyToOne(optional = false)
    @JsonManagedReference
    private Tobacco tobacco;

    @MapsId("restaurantId")
    @ManyToOne(optional = false)
    @JsonManagedReference
    private Restaurant restaurant;

    @Column(nullable = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    private TobaccoStatus status;

    @Column
    private Short amount;

}
