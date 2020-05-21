package com.example.hookah.controller.mapper;

import com.example.hookah.controller.dto.TobaccoDTO;
import com.example.hookah.model.Tobacco;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TobaccoMapper {

    TobaccoDTO tobaccoToTobaccoDTO(Tobacco tobacco);

    List<TobaccoDTO> tobaccosToTobaccoDTOs(List<Tobacco> tobaccos);

    @Mappings({
            @Mapping(target = "hookahHistories", ignore = true),
    })
    Tobacco tobaccoDTOToTobacco(TobaccoDTO tobaccoDTO);

    List<Tobacco> tobaccoDTOsToTobaccos(List<TobaccoDTO> tobaccoDTOs);
}
