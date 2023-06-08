package com.example.memo.service;

import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatgptService chatgptService;

    public String getGPTAnswer(String resultQuestion) {
        return chatgptService.sendMessage(resultQuestion);
    }
}
