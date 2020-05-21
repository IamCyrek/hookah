package com.example.hookah.service;

import com.example.hookah.model.FavouriteRestaurant;
import com.example.hookah.repository.FavouriteRestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavouriteRestaurantService {

    private final FavouriteRestaurantRepository favouriteRestaurantRepository;

    public List<FavouriteRestaurant> getAll(Sort sort) {
        return favouriteRestaurantRepository.findAll(sort);
    }

}
