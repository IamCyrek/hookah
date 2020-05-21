package com.example.hookah.repository;

import com.example.hookah.model.FavouriteRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteRestaurantRepository extends JpaRepository<FavouriteRestaurant, Long> {
}
