package com.example.hookah.controller.mapper;

import com.example.hookah.controller.dto.HookahHistoryDTO;
import com.example.hookah.model.HookahHistory;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = { HookahMapper.class,
        TobaccoMapper.class, UserMapper.class, RestaurantMapper.class })
public interface HookahHistoryMapper {

    HookahHistoryDTO hookahHistoryToHookahHistoryDTO(HookahHistory hookahHistory);

    List<HookahHistoryDTO> hookahHistoriesToHookahHistoryDTOs(List<HookahHistory> hookahHistories);

    HookahHistory hookahHistoryDTOToHookahHistory(HookahHistoryDTO hookahHistoryDTO);

    List<HookahHistory> hookahHistoryDTOsToHookahHistories(List<HookahHistoryDTO> hookahHistoryDTOs);
}
