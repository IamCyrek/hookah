package com.example.hookah.repository;

import com.example.hookah.model.RestaurantReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantReviewRepository extends JpaRepository<RestaurantReview, Long> {
}
