package com.example.hookah.controller.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class RestaurantReviewDTO {

    @NotNull
    private Long userId;

    @NotNull
    private Long restaurantId;

    @NotNull
    @Min(0)
    @Max(3)
    private Short rating;

    @NotBlank
    @Size(min = 3, max = 255)
    private String comment;

}
