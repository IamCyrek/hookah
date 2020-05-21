package com.example.hookah.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class FavouriteRestaurant {

    @EmbeddedId
    private FavouriteRestaurantIdentity id;

    @MapsId("userId")
    @ManyToOne(optional = false)
    @JsonManagedReference
    private User user;

    @MapsId("restaurantId")
    @ManyToOne(optional = false)
    @JsonManagedReference
    private Restaurant restaurant;

}
