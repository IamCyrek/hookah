package com.example.hookah.controller.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class HookahHistoryDTO {

    private Long id;

    private HookahDTO hookah;

    private TobaccoDTO tobacco;

    private UserDTO administrator;

    private UserDTO visitor;

    private RestaurantDTO restaurant;

    @NotNull
    @Min(0)
    private BigDecimal cash;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

}
