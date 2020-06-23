package com.example.hookah.controller.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class RestaurantDTO {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 255)
    private String name;

    @NotBlank
    @Size(min = 3, max = 2000)
    private String description;

    @NotBlank
    @Size(min = 3, max = 255)
    private String address;

    @NotBlank
    @Size(min = 3, max = 16)
    private String number;

    private Float latitude;

    private Float longitude;

    @NotNull
    @Min(0)
    @Max(3)
    private Short rating;

    private Short maxNumberReservations;

    @NotNull
    private Boolean isFavourite;

}
