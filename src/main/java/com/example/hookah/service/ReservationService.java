package com.example.hookah.service;

import com.example.hookah.model.Reservation;
import com.example.hookah.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public List<Reservation> getAll(Sort sort) {
        return reservationRepository.findAll(sort);
    }

}
