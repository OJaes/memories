package com.ojg.memories_back.service.implement;

import com.ojg.memories_back.common.dto.request.openai.ChatRequestDto;
import com.ojg.memories_back.common.dto.response.openai.ChatResponseDto;
import com.ojg.memories_back.common.vo.GptMessageVo;
import com.ojg.memories_back.service.OpenAIService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class OpenAIServiceImplement implements OpenAIService{
    
    private final WebClient webClient;

    @Override
    public String chat() {
        String content = "삼성전자에 대해 알려줘";
        List<GptMessageVo> message = List.of(new GptMessageVo("user", content));
        ChatRequestDto requestBody = new ChatRequestDto("gpt-4o-mini", message);

        ChatResponseDto responseBody = webClient.post()
        .uri("/chat/completions")
        .bodyValue(requestBody)
        .retrieve()
        .bodyToMono(ChatResponseDto.class)
        .block();

        if(responseBody == null || responseBody.getChoices() == null || responseBody.getChoices().isEmpty()) {
            return null;
        }

        return responseBody.getChoices().get(0).getMessage().getContent();
        
    }
    
}
