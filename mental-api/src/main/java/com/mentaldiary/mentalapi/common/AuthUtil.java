package com.mentaldiary.mentalapi.common;

import com.mentaldiary.mentalapi.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthUtil {

    public User getLoginUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }

    public Long getUserIdx() {
        Long userIdx = getLoginUser().getId();
        return userIdx;

    }
}
