package com.example.hookah.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank
    @Size(min = 3, max = 255)
    private String name;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 3, max = 2000)
    private String description;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 3, max = 255)
    private String address;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 3, max = 16)
    private String number;

    @Column
    private Float latitude;

    @Column
    private Float longitude;

    @Column(nullable = false)
    @NotNull
    @Min(0)
    @Max(3)
    private Short rating;

    @OneToMany(mappedBy = "restaurant")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private Set<Hookah> hookahs = new HashSet<>();

    @OneToMany(mappedBy = "restaurant")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private Set<RestaurantReview> restaurantReviews = new HashSet<>();

    @OneToMany(mappedBy = "restaurant")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private Set<FavouriteRestaurant> favouriteRestaurants = new HashSet<>();

}
