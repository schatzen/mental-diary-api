package com.mentaldiary.mentalapi.v1.user.service;

import com.mentaldiary.mentalapi.entity.User;
import com.mentaldiary.mentalapi.respository.UserRepo;
import com.mentaldiary.mentalapi.v1.response.service.ResponseService;
import com.mentaldiary.mentalapi.v1.response.vo.SingleResult;
import com.mentaldiary.mentalapi.v1.user.vo.SignUpVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    // 회원가입
    public void signUp(SignUpVO vo) {
        User user = User.builder()
                .email(vo.getEmail())
                .password(vo.getPassword())
                .birthdate(vo.getBirthdate())
                .gender(vo.getGender()).build();

        user = userRepo.save(user);
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
}
