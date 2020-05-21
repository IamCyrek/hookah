package com.example.hookah.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table
public class Hookah {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank
    @Size(min = 3, max = 255)
    private String name;

    @Column
    @Min(0)
    @Max(100)
    private Short charge;

    @Column(nullable = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    private HookahStatus status;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonManagedReference
    private Restaurant restaurant;

    @OneToMany(mappedBy = "hookah")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private Set<HookahHistory> hookahHistories = new HashSet<>();

}
