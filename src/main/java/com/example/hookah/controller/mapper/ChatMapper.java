package com.example.hookah.controller.mapper;

import com.example.hookah.controller.dto.ChatDTO;
import com.example.hookah.model.Chat;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = { UserMapper.class })
public interface ChatMapper {

    ChatDTO chatToChatDTO(Chat chat);

    List<ChatDTO> chatsToChatDTOs(List<Chat> chats);

    Chat chatDTOToChat(ChatDTO chatDTO);

    List<Chat> chatDTOsToChats(List<ChatDTO> chatDTOs);
}
