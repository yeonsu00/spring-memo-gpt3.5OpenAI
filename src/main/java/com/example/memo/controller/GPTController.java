package com.example.memo.controller;

import com.example.memo.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gpt")
public class GPTController {
    String qreQuestion = "\n위의 문장을 교정해줘.";
    private final ChatService chatService;

    // 질문을 입력하고 답변을 받는다
    @PostMapping("/askGPT")
    public String test(@RequestBody String question){
        String resultQuestion = question + qreQuestion;
        return chatService.getGPTAnswer(resultQuestion);
    }
}
