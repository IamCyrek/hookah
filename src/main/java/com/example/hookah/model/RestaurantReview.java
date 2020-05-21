package com.example.hookah.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@Table
public class RestaurantReview {

    @EmbeddedId
    private RestaurantReviewIdentity id;

    @MapsId("userId")
    @ManyToOne(optional = false)
    @JsonManagedReference
    private User user;

    @MapsId("restaurantId")
    @ManyToOne(optional = false)
    @JsonManagedReference
    private Restaurant restaurant;

    @Column(nullable = false)
    @NotNull
    @Min(0)
    @Max(3)
    private Short rating;

    @Column
    @NotBlank
    @Size(min = 3, max = 255)
    private String comment;

}
