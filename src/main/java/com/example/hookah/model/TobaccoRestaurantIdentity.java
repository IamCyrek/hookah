package com.example.hookah.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
@Data
public class TobaccoRestaurantIdentity implements Serializable {

    @Column(nullable = false)
    @NotNull
    private Long tobaccoId;

    @Column(nullable = false)
    @NotNull
    private Long restaurantId;

}
