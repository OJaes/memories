package com.ojg.memories_back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojg.memories_back.service.OpenAIService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/open-ai")
public class OpenAIController {
    private final OpenAIService openAIService;

    @GetMapping("")
    public String chat() {
        return openAIService.chat();
    }
    
}
