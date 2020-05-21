package com.example.hookah.service;

import com.example.hookah.model.RestaurantReview;
import com.example.hookah.repository.RestaurantReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantReviewService {

    private final RestaurantReviewRepository restaurantReviewRepository;

    public List<RestaurantReview> getAll(Sort sort) {
        return restaurantReviewRepository.findAll(sort);
    }

}
