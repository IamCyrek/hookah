package com.example.hookah.repository;

import com.example.hookah.model.TobaccoRestaurant;
import com.example.hookah.model.TobaccoRestaurantIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TobaccoRestaurantRepository extends JpaRepository<TobaccoRestaurant, TobaccoRestaurantIdentity> {
}
