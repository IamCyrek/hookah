package com.example.hookah.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class UserDTO {

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

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime createdAt;

    private Boolean isEnabled;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String accountLevelName;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long smokingTime;

}
