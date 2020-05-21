package com.example.hookah.controller;

import com.example.hookah.controller.dto.TobaccoDTO;
import com.example.hookah.controller.mapper.TobaccoMapper;
import com.example.hookah.service.TobaccoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import static com.example.hookah.configuration.Constants.API_TOBACCOS;

@RestController
@RequestMapping(API_TOBACCOS)
@RequiredArgsConstructor
public class TobaccoController {

    private final TobaccoService tobaccoService;

    private final TobaccoMapper tobaccoMapper;

    @GetMapping
    public Page<TobaccoDTO> getAll(@PageableDefault(sort = "id") Pageable pageable) {
        return tobaccoService.getAll(pageable).map(tobaccoMapper::tobaccoToTobaccoDTO);
    }

}
