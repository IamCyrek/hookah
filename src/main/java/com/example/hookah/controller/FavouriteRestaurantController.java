package com.example.hookah.controller;

import com.example.hookah.controller.dto.FavouriteRestaurantDTO;
import com.example.hookah.controller.mapper.FavouriteRestaurantMapper;
import com.example.hookah.service.FavouriteRestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.hookah.configuration.Constants.API_FAVOURITE_RESTAURANTS;

@RestController
@RequestMapping(API_FAVOURITE_RESTAURANTS)
@RequiredArgsConstructor
public class FavouriteRestaurantController {

    private final FavouriteRestaurantService favouriteRestaurantService;

    private final FavouriteRestaurantMapper favouriteRestaurantMapper;

    @GetMapping
    public List<FavouriteRestaurantDTO> getAll(@SortDefault(sort = "id") Sort sort) {
        return favouriteRestaurantMapper.favouriteRestaurantsToFavouriteRestaurantDTOs(
                favouriteRestaurantService.getAll(sort));
    }

}
