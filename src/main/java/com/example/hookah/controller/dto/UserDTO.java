package com.example.hookah.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class UserDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 255)
    private String name;

    @Email
    @NotBlank
    @Size(min = 3, max = 63)
    private String email;

    @NotBlank
    @Size(min = 8, max = 63)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @DateTimeFormat
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime createdAt;

    private Boolean isEnabled;

}
