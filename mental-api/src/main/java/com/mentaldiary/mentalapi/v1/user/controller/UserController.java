package com.mentaldiary.mentalapi.v1.user.controller;

import com.mentaldiary.mentalapi.entity.User;
import com.mentaldiary.mentalapi.v1.response.service.ResponseService;
import com.mentaldiary.mentalapi.v1.response.vo.SingleResult;
import com.mentaldiary.mentalapi.v1.user.service.UserService;
import com.mentaldiary.mentalapi.v1.user.vo.SignUpVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"1. User"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;
    private final ResponseService responseService;

    @PostMapping
    @ApiOperation(value = "회원가입", notes = "회원가입을 한다.")
    public SingleResult<User> save(SignUpVO signUpVO) {

    User user = userService.signUp(signUpVO);

    return responseService.getSingleResult(user);

    }



}
