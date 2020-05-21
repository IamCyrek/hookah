package com.example.hookah.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FavouriteRestaurantDTO {

    @NotNull
    private Long userId;

    @NotNull
    private Long restaurantId;

}
