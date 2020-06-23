package com.example.hookah.controller.mapper;

import com.example.hookah.controller.dto.TobaccoRestaurantDTO;
import com.example.hookah.model.TobaccoRestaurant;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TobaccoRestaurantMapper {

    @Mappings({
            @Mapping(source = "id.tobaccoId", target = "tobaccoId"),
            @Mapping(source = "id.restaurantId", target = "restaurantId"),
    })
    TobaccoRestaurantDTO tobaccoRestaurantToTobaccoRestaurantDTO(TobaccoRestaurant tobaccoRestaurant);

    List<TobaccoRestaurantDTO> tobaccoRestaurantsToTobaccoRestaurantDTOs(
            List<TobaccoRestaurant> tobaccoRestaurants);

    @Mappings({
            @Mapping(source = "tobaccoId", target = "id.tobaccoId"),
            @Mapping(source = "restaurantId", target = "id.restaurantId"),
            @Mapping(target = "tobacco", ignore = true),
            @Mapping(target = "restaurant", ignore = true),
    })
    TobaccoRestaurant tobaccoRestaurantDTOToTobaccoRestaurant(TobaccoRestaurantDTO tobaccoRestaurantDTO);

    List<TobaccoRestaurant> tobaccoRestaurantDTOsToTobaccoRestaurants(
            List<TobaccoRestaurantDTO> tobaccoRestaurantDTOs);
}
