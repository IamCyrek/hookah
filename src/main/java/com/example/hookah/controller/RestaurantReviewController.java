package com.example.hookah.controller;

import com.example.hookah.controller.dto.RestaurantReviewDTO;
import com.example.hookah.controller.mapper.RestaurantReviewMapper;
import com.example.hookah.service.RestaurantReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.hookah.configuration.Constants.API_RESTAURANT_REVIEWS;

@RestController
@RequestMapping(API_RESTAURANT_REVIEWS)
@RequiredArgsConstructor
public class RestaurantReviewController {

    private final RestaurantReviewService restaurantReviewService;

    private final RestaurantReviewMapper restaurantReviewMapper;

    @GetMapping
    public List<RestaurantReviewDTO> getAll(@SortDefault(sort = "id") Sort sort) {
        return restaurantReviewMapper.restaurantReviewsToRestaurantReviewDTOs(restaurantReviewService.getAll(sort));
    }

}
