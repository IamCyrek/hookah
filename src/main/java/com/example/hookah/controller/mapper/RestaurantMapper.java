package com.example.hookah.controller.mapper;

import com.example.hookah.controller.dto.RestaurantDTO;
import com.example.hookah.model.Restaurant;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {})
public interface RestaurantMapper {

    RestaurantDTO restaurantToRestaurantDTO(Restaurant restaurant);

    List<RestaurantDTO> restaurantsToRestaurantDTOs(List<Restaurant> restaurants);

    @Mappings({
            @Mapping(target = "hookahs", ignore = true),
            @Mapping(target = "hookahHistories", ignore = true),
            @Mapping(target = "users", ignore = true),
            @Mapping(target = "reservations", ignore = true),
            @Mapping(target = "restaurantReviews", ignore = true),
            @Mapping(target = "favouriteRestaurants", ignore = true),
            @Mapping(target = "tobaccoRestaurants", ignore = true),
    })
    Restaurant restaurantDTOToRestaurant(RestaurantDTO restaurantDTO);

    List<Restaurant> restaurantDTOsToRestaurants(List<RestaurantDTO> restaurantDTOs);
}
