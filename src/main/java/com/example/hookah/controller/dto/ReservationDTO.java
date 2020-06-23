package com.example.hookah.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class ReservationDTO {

    private Long id;

    private RestaurantDTO restaurant;

    private UserDTO user;

    @NotNull
    private LocalDateTime createdAt;

    private Short maxNumberReservations;

}
