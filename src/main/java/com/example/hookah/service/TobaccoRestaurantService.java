package com.example.hookah.service;

import com.example.hookah.model.TobaccoRestaurant;
import com.example.hookah.repository.TobaccoRestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TobaccoRestaurantService {

    private final TobaccoRestaurantRepository tobaccoRestaurantRepository;

    public List<TobaccoRestaurant> getAll(Sort sort) {
        return tobaccoRestaurantRepository.findAll(sort);
    }

}
