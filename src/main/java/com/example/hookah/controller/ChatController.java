package com.example.hookah.controller;

import com.example.hookah.controller.dto.ChatDTO;
import com.example.hookah.controller.mapper.ChatMapper;
import com.example.hookah.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.hookah.configuration.Constants.API_CHATS;

@RestController
@RequestMapping(API_CHATS)
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    private final ChatMapper chatMapper;

    @GetMapping
    public List<ChatDTO> getAll(@SortDefault(sort = "id") Sort sort) {
        return chatMapper.chatsToChatDTOs(chatService.getAll(sort));
    }

}
