package com.example.hookah.repository;

import com.example.hookah.model.Hookah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HookahRepository extends JpaRepository<Hookah, Long> {
}
