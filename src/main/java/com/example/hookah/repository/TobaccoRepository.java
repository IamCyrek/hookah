package com.example.hookah.repository;

import com.example.hookah.model.Tobacco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TobaccoRepository extends JpaRepository<Tobacco, Long> {
}
