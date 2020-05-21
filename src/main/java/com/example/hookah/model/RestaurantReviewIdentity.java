package com.example.hookah.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
@Data
public class RestaurantReviewIdentity implements Serializable {

    @Column(nullable = false)
    @NotNull
    private Long userId;

    @Column(nullable = false)
    @NotNull
    private Long restaurantId;

}
