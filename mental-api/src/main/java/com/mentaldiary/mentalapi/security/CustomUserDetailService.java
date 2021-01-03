package com.mentaldiary.mentalapi.security;


import com.mentaldiary.mentalapi.advice.exception.SignExeption;
import com.mentaldiary.mentalapi.respository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepo userRepo;

    public UserDetails loadUserByUsername(String userPk) {
        return userRepo.findById(Long.valueOf(userPk)).orElseThrow(SignExeption::new);

    }
}
