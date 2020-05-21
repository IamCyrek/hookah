package com.example.hookah.service;

import com.example.hookah.model.Hookah;
import com.example.hookah.repository.HookahRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HookahService {

    private final HookahRepository hookahRepository;

    public Page<Hookah> getAll(Pageable pageable) {
        return hookahRepository.findAll(pageable);
    }

}
