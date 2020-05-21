package com.example.hookah.controller.dto;

import com.example.hookah.model.HookahStatus;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class HookahDTO {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 255)
    private String name;

    @Min(0)
    @Max(100)
    private Short charge;

    @NotNull
    private HookahStatus status;

    private RestaurantDTO restaurant;

}
