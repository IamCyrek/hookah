package com.example.hookah.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table
public class Tobacco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "custom_tobacco_id", nullable = false)
    @NotBlank
    @Size(min = 3, max = 31)
    private String customTobaccoId;

    @Column(nullable = false, unique = true)
    @NotBlank
    @Size(min = 3, max = 255)
    private String name;

    @Column
    @Size(max = 4095)
    private String profile;

    @OneToMany(mappedBy = "tobacco")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private Set<HookahHistory> hookahHistories = new HashSet<>();

    @OneToMany(mappedBy = "tobacco")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private Set<TobaccoRestaurant> tobaccoRestaurants = new HashSet<>();

}
