package com.example.hookah.controller.dto;

import com.example.hookah.model.TobaccoStatus;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TobaccoDTO {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 31)
    private String customTobaccoId;

    @NotBlank
    @Size(min = 3, max = 255)
    private String name;

    @NotNull
    private TobaccoStatus status;

}
