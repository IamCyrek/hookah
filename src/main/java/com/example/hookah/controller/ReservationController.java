package com.example.hookah.controller;

import com.example.hookah.controller.dto.ReservationDTO;
import com.example.hookah.controller.mapper.ReservationMapper;
import com.example.hookah.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.hookah.configuration.Constants.API_RESERVATIONS;

@RestController
@RequestMapping(API_RESERVATIONS)
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    private final ReservationMapper reservationMapper;

    @GetMapping
    public List<ReservationDTO> getAll(@SortDefault(sort = "id") Sort sort) {
        return reservationMapper.reservationsToReservationDTOs(reservationService.getAll(sort));
    }

}
