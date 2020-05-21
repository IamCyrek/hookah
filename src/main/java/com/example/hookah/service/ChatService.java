package com.example.hookah.service;

import com.example.hookah.model.Chat;
import com.example.hookah.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    public List<Chat> getAll(Sort sort) {
        return chatRepository.findAll(sort);
    }

}
