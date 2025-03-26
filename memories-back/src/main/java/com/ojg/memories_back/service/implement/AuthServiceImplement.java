package com.ojg.memories_back.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ojg.memories_back.common.dto.request.auth.IdCheckRequestDto;
import com.ojg.memories_back.common.dto.request.auth.SignInRequestDto;
import com.ojg.memories_back.common.dto.request.auth.SignUpRequestDto;
import com.ojg.memories_back.common.dto.response.auth.ResponseDto;
import com.ojg.memories_back.common.dto.response.auth.SignInResponseDto;
import com.ojg.memories_back.common.entity.UserEntity;
import com.ojg.memories_back.provider.JwtProvider;
import com.ojg.memories_back.repository.UserRepository;
import com.ojg.memories_back.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final JwtProvider jwtProvider;

  @Override
  public ResponseEntity<ResponseDto> idCheck(IdCheckRequestDto dto) {

    try {
        String userId = dto.getUserId();
        boolean existsUser = userRepository.existsByUserId(userId);
        if(existsUser){
            return ResponseDto.existUser();
        }
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseDto.databaseError();
    }

    return ResponseDto.success(HttpStatus.OK);
}


@Override
public ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto) {

    try {
        
        String userId = dto.getUserId();
        boolean existsUser = userRepository.existsByUserId(userId);
        if(existsUser) return ResponseDto.existUser();
        
        String userPassword = dto.getUserPassword();
        String encodedPassword = passwordEncoder.encode(userPassword);

        dto.setUserPassword(encodedPassword);

        UserEntity userEntity = new UserEntity(dto);
        userRepository.save(userEntity);

    } catch (Exception e) {
        e.printStackTrace();
        return ResponseDto.databaseError();
    }

    return ResponseDto.success(HttpStatus.CREATED);
}


@Override
public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {
    
    String accessToken = null;

    try {
        String userId = dto.getUserId();
        UserEntity userEntity = userRepository.findByUserId(userId);
        if(userEntity == null) return ResponseDto.signInFail();

        String userPassword = dto.getUserPassword();

        String encodedPassword = userEntity.getUserPassword();
        boolean isMatch =  passwordEncoder.matches(userPassword, encodedPassword);
        if(!isMatch) return ResponseDto.signInFail();

        accessToken = jwtProvider.create(userId);
    } catch (Exception e) {
        e.printStackTrace();
    }

    return SignInResponseDto.success(accessToken);
}
  
}