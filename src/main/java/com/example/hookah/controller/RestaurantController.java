package com.example.hookah.controller;

import com.example.hookah.controller.dto.RestaurantDTO;
import com.example.hookah.controller.mapper.RestaurantMapper;
import com.example.hookah.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.hookah.configuration.Constants.API_RESTAURANTS;

@RestController
@RequestMapping(API_RESTAURANTS)
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    private final RestaurantMapper restaurantMapper;

    @GetMapping
    public List<RestaurantDTO> getAll(@SortDefault(sort = "id") Sort sort) {
        return restaurantMapper.restaurantsToRestaurantDTOs(restaurantService.getAll(sort));
    }

}
