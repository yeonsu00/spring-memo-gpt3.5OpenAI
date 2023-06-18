package com.example.memo.controller;

import com.example.memo.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> questionCorrection(@RequestBody String question) {
        try {
            String resultQuestion = question + qreQuestion;
            String answer = chatService.getGPTAnswer(resultQuestion);
            return ResponseEntity.ok(answer);
        } catch (Exception e) {
            String errorMessage = "오류 메시지: ";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
}
