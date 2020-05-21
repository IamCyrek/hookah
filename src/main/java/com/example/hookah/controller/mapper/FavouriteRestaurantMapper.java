package com.example.hookah.controller.mapper;

import com.example.hookah.controller.dto.FavouriteRestaurantDTO;
import com.example.hookah.model.FavouriteRestaurant;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface FavouriteRestaurantMapper {

    @Mappings({
            @Mapping(source = "id.userId", target = "userId"),
            @Mapping(source = "id.restaurantId", target = "restaurantId"),
    })
    FavouriteRestaurantDTO favouriteRestaurantToFavouriteRestaurantDTO(FavouriteRestaurant favouriteRestaurant);

    List<FavouriteRestaurantDTO> favouriteRestaurantsToFavouriteRestaurantDTOs(
            List<FavouriteRestaurant> favouriteRestaurants);

    @Mappings({
            @Mapping(source = "userId", target = "id.userId"),
            @Mapping(source = "restaurantId", target = "id.restaurantId"),
            @Mapping(target = "user", ignore = true),
            @Mapping(target = "restaurant", ignore = true),
    })
    FavouriteRestaurant favouriteRestaurantDTOToFavouriteRestaurant(FavouriteRestaurantDTO favouriteRestaurantDTO);

    List<FavouriteRestaurant> favouriteRestaurantDTOsToFavouriteRestaurants(
            List<FavouriteRestaurantDTO> favouriteRestaurantDTOs);
}
