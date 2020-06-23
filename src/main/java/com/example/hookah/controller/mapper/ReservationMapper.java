package com.example.hookah.controller.mapper;

import com.example.hookah.controller.dto.ReservationDTO;
import com.example.hookah.model.Reservation;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = { RestaurantMapper.class,
        UserMapper.class })
public interface ReservationMapper {

    ReservationDTO reservationToReservationDTO(Reservation reservation);

    List<ReservationDTO> reservationsToReservationDTOs(List<Reservation> reservations);

    Reservation reservationDTOToReservation(ReservationDTO reservationDTO);

    List<Reservation> reservationDTOsToReservations(List<ReservationDTO> reservationDTOs);
}
