package com.example.hookah.controller;

import com.example.hookah.controller.dto.HookahDTO;
import com.example.hookah.controller.mapper.HookahMapper;
import com.example.hookah.service.HookahService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.hookah.configuration.Constants.API_HOOKAHS;

@RestController
@RequestMapping(API_HOOKAHS)
@RequiredArgsConstructor
public class HookahController {

    private final HookahService hookahService;

    private final HookahMapper hookahMapper;

    @GetMapping
    public Page<HookahDTO> getAll(@PageableDefault(sort = "id") Pageable pageable) {
        return hookahService.getAll(pageable).map(hookahMapper::hookahToHookahDTO);
    }

}
