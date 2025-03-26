package com.ojg.memories_back.service;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;

import com.ojg.memories_back.common.dto.request.test.PostConcentrationRequestDto;
import com.ojg.memories_back.common.dto.request.test.PostMemoryRequestDto;
import com.ojg.memories_back.common.dto.response.ResponseDto;
import com.ojg.memories_back.common.dto.response.test.GetConcentrationResponseDto;
import com.ojg.memories_back.common.dto.response.test.GetMemoryResponseDto;
import com.ojg.memories_back.common.dto.response.test.GetRecentlyConcentrationResponseDto;
import com.ojg.memories_back.common.dto.response.test.GetRecentlyMemoryResponseDto;

public interface TestService {
  ResponseEntity<ResponseDto> postMemory(PostMemoryRequestDto dto, String userId);
  ResponseEntity<? super GetMemoryResponseDto> getMemory(String userId);

  ResponseEntity<ResponseDto> postConcentration(PostConcentrationRequestDto dto, String userId);
  ResponseEntity<? super GetConcentrationResponseDto> getConcentration(String userId);

  ResponseEntity<? super GetRecentlyMemoryResponseDto> getRecentMemory(String userId);
  ResponseEntity<? super GetRecentlyConcentrationResponseDto> getRecentlyConcentration(String userId);
}