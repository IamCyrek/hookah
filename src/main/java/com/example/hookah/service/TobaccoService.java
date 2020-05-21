package com.example.hookah.service;

import com.example.hookah.model.Tobacco;
import com.example.hookah.repository.TobaccoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TobaccoService {

    private final TobaccoRepository tobaccoRepository;

    public Page<Tobacco> getAll(Pageable pageable) {
        return tobaccoRepository.findAll(pageable);
    }

}
