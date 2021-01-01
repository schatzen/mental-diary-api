package com.mentaldiary.mentalapi.v1.user.service;

import com.mentaldiary.mentalapi.entity.User;
import com.mentaldiary.mentalapi.respository.UserRepo;
import com.mentaldiary.mentalapi.v1.response.service.ResponseService;
import com.mentaldiary.mentalapi.v1.response.vo.SingleResult;
import com.mentaldiary.mentalapi.v1.user.vo.SignUpVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    // 회원가입
    public User signUp(SignUpVO vo) {
        User user = User.builder()
                .email(vo.getEmail())
                .password(vo.getPassword())
                .gender(vo.getGender()).build();

        user = userRepo.save(user);

        return user;

    }
}
