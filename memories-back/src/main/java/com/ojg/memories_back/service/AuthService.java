package com.ojg.memories_back.service;

import org.springframework.http.ResponseEntity;

import com.ojg.memories_back.common.dto.request.auth.IdCheckRequestDto;
import com.ojg.memories_back.common.dto.request.auth.SignInRequestDto;
import com.ojg.memories_back.common.dto.request.auth.SignUpRequestDto;
import com.ojg.memories_back.common.dto.response.auth.ResponseDto;
import com.ojg.memories_back.common.dto.response.auth.SignInResponseDto;

public interface AuthService {
  ResponseEntity<ResponseDto> idCheck(IdCheckRequestDto dto);
  ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto);
  ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
}