package com.example.hookah.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "hookah_history")
public class HookahHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "hookah_id", nullable = false)
    @JsonManagedReference
    private Hookah hookah;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tobacco_id", nullable = false)
    @JsonManagedReference
    private Tobacco tobacco;

    @ManyToOne(optional = false)
    @JoinColumn(name = "administrator_id", nullable = false)
    @JsonManagedReference
    private User administrator;

    @ManyToOne(optional = false)
    @JoinColumn(name = "visitor_id", nullable = false)
    @JsonManagedReference
    private User visitor;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonManagedReference
    private Restaurant restaurant;

    @Column(nullable = false, name = "cash")
    @NotNull
    @Min(0)
    private BigDecimal cash;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

}
