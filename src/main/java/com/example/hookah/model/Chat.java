package com.example.hookah.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Data
@Table
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonManagedReference
    private User user;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 3, max = 255)
    private String message;

    @Column
    private LocalDateTime creationTime;

}
