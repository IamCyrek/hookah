package com.example.hookah.service;

import com.example.hookah.model.Restaurant;
import com.example.hookah.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public List<Restaurant> getAll(Sort sort) {
        return restaurantRepository.findAll(sort);
    }

}
