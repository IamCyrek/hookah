package com.example.hookah.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class ChatDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UserDTO user;

    @NotBlank
    @Size(min = 3, max = 255)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String message;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime creationTime;

}
