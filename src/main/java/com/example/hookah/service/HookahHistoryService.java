package com.example.hookah.service;

import com.example.hookah.model.HookahHistory;
import com.example.hookah.repository.HookahHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HookahHistoryService {

    private final HookahHistoryRepository hookahHistoryRepository;

    public Page<HookahHistory> getAll(Pageable pageable) {
        return hookahHistoryRepository.findAll(pageable);
    }

}
