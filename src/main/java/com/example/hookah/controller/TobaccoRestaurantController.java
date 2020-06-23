package com.example.hookah.controller;

import com.example.hookah.controller.dto.TobaccoRestaurantDTO;
import com.example.hookah.controller.mapper.TobaccoRestaurantMapper;
import com.example.hookah.service.TobaccoRestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.hookah.configuration.Constants.API_TOBACCO_RESTAURANTS;

@RestController
@RequestMapping(API_TOBACCO_RESTAURANTS)
@RequiredArgsConstructor
public class TobaccoRestaurantController {

    private final TobaccoRestaurantService tobaccoRestaurantService;

    private final TobaccoRestaurantMapper tobaccoRestaurantMapper;

    @GetMapping
    public List<TobaccoRestaurantDTO> getAll(@SortDefault(sort = "id") Sort sort) {
        return tobaccoRestaurantMapper.tobaccoRestaurantsToTobaccoRestaurantDTOs(
                tobaccoRestaurantService.getAll(sort));
    }

}
