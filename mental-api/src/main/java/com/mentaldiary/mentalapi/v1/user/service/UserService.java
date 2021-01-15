package com.mentaldiary.mentalapi.v1.user.service;

import com.mentaldiary.mentalapi.advice.exception.CUserNotFoundException;
import com.mentaldiary.mentalapi.entity.User;
import com.mentaldiary.mentalapi.advice.exception.SignExeption;
import com.mentaldiary.mentalapi.respository.UserRepo;
import com.mentaldiary.mentalapi.utils.ModelMapperUtil;
import com.mentaldiary.mentalapi.v1.user.vo.SignUpVO;
import com.mentaldiary.mentalapi.v1.user.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;


    // 회원가입
    public void signUp(SignUpVO vo) {
        userRepo.save(User.builder()
                .email(vo.getEmail())
                .password(vo.getPassword())
                .birthdate(vo.getBirthdate())
                .gender(vo.getGender())
                .roles(Collections.singletonList("ROLE_USER"))
                .build());
    }


    // 유효성 체크 메소드
    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }

        return validatorResult;
    }

    public User checkDuplicatedEmail(String email) {
        User user = userRepo.findByEmail(email).orElse(null);
        return user;
    }

    public User signIn(SignUpVO signUpV0) throws Exception {

        User user = userRepo.findByEmail(signUpV0.getEmail()).orElseThrow(CUserNotFoundException::new);

        if (!user.getPassword().matches(signUpV0.getPassword())) {
            throw new CUserNotFoundException();
        }
        return user;
    }
}
