package com.example.hookah.controller.mapper;

import com.example.hookah.controller.dto.RestaurantReviewDTO;
import com.example.hookah.model.RestaurantReview;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RestaurantReviewMapper {

    @Mappings({
            @Mapping(source = "id.userId", target = "userId"),
            @Mapping(source = "id.restaurantId", target = "restaurantId"),
    })
    RestaurantReviewDTO restaurantReviewToRestaurantReviewDTO(RestaurantReview restaurantReview);

    List<RestaurantReviewDTO> restaurantReviewsToRestaurantReviewDTOs(List<RestaurantReview> restaurantReviews);

    @Mappings({
            @Mapping(source = "userId", target = "id.userId"),
            @Mapping(source = "restaurantId", target = "id.restaurantId"),
            @Mapping(target = "user", ignore = true),
            @Mapping(target = "restaurant", ignore = true),
    })
    RestaurantReview restaurantReviewDTOToRestaurantReview(RestaurantReviewDTO restaurantReviewDTO);

    List<RestaurantReview> restaurantReviewDTOsToRestaurantReviews(List<RestaurantReviewDTO> restaurantReviewDTOs);
}
