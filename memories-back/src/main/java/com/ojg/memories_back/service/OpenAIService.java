package com.ojg.memories_back.service;

import org.springframework.http.ResponseEntity;

import com.ojg.memories_back.common.dto.request.openai.GetWayRequestDto;
import com.ojg.memories_back.common.dto.response.openai.GetWayResponseDto;

public interface OpenAIService {
        ResponseEntity<? super GetWayResponseDto> getWay(GetWayRequestDto dto, String userId);
        
}
