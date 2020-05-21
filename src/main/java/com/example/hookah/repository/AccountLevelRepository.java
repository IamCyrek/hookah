package com.example.hookah.repository;

import com.example.hookah.model.AccountLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountLevelRepository extends JpaRepository<AccountLevel, Long> {

    Optional<AccountLevel> findFirstByValueIsLessThanEqual(Long value);

}
