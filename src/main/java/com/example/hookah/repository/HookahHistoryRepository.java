package com.example.hookah.repository;

import com.example.hookah.model.HookahHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HookahHistoryRepository extends JpaRepository<HookahHistory, Long> {
}
