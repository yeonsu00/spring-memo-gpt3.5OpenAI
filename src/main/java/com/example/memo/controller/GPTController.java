package com.example.memo.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gpt")
public class GPTController {
//    String qreQuestion = "\n위의 문장을 교정해줘.";
//    String qreQuestion = "";
//    private final ChatService chatService;
//
//    // 질문을 입력하고 답변을 받는다
//    @PostMapping("/askGPT")
//    public ResponseEntity<String> questionCorrection(@RequestBody String question) {
//        try {
//            String resultQuestion = question + qreQuestion;
//            String answer = chatService.getGPTAnswer(resultQuestion);
//            return ResponseEntity.ok(answer);
//        } catch (Exception e) {
//            String errorMessage = "오류 메시지: ";
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
//        }
//    }

    @PostMapping("/send")
    public ResponseEntity send(String message) {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder
                .fromUriString("https://api.openai.com/v1/chat/completions")
                .build()
                .encode()
                .toUri();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + "key");

        ArrayList<Message> list = new ArrayList<>();
        list.add(new Message("user",message));


        Body body = new Body("gpt-3.5-turbo", list);

        RequestEntity<Body> httpEntity = new RequestEntity<>(body, httpHeaders, HttpMethod.POST, uri);

        return restTemplate.exchange(httpEntity, String.class);
    }

    @AllArgsConstructor
    @Data
    static class Body {
        String model;
        List<Message> messages;
    }

    @AllArgsConstructor
    @Data
    static class Message {
        String role;
        String content;
    }
}
