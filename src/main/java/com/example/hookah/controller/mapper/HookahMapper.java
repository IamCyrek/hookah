package com.example.hookah.controller.mapper;

import com.example.hookah.controller.dto.HookahDTO;
import com.example.hookah.model.Hookah;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = { RestaurantMapper.class })
public interface HookahMapper {

    HookahDTO hookahToHookahDTO(Hookah hookah);

    List<HookahDTO> hookahsToHookahDTOs(List<Hookah> hookahs);

    @Mappings({
            @Mapping(target = "hookahHistories", ignore = true),
    })
    Hookah hookahDTOToHookah(HookahDTO hookahDTO);

    List<Hookah> hookahDTOsToHookahs(List<HookahDTO> hookahDTOs);
}
