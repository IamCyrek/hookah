package com.example.hookah.controller;

import com.example.hookah.controller.dto.HookahHistoryDTO;
import com.example.hookah.controller.mapper.HookahHistoryMapper;
import com.example.hookah.service.HookahHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.hookah.configuration.Constants.API_HOOKAH_HISTORIES;

@RestController
@RequestMapping(API_HOOKAH_HISTORIES)
@RequiredArgsConstructor
public class HookahHistoryController {

    private final HookahHistoryService hookahHistoryService;

    private final HookahHistoryMapper hookahHistoryMapper;

    @GetMapping
    public Page<HookahHistoryDTO> getAll(@PageableDefault(sort = "id") Pageable pageable) {
        return hookahHistoryService.getAll(pageable).map(hookahHistoryMapper::hookahHistoryToHookahHistoryDTO);
    }

}
