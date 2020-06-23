package com.example.hookah.controller.dto;

import com.example.hookah.model.TobaccoStatus;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class TobaccoRestaurantDTO {

    @NotNull
    private Long tobaccoId;

    @NotNull
    private Long restaurantId;

    @NotNull
    private TobaccoStatus status;

    private Short amount;

}
