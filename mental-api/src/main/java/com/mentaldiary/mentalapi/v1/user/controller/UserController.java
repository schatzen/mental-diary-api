package com.mentaldiary.mentalapi.v1.user.controller;

import com.mentaldiary.mentalapi.entity.User;
import com.mentaldiary.mentalapi.exception.SignExeption;
import com.mentaldiary.mentalapi.v1.response.service.ResponseService;
import com.mentaldiary.mentalapi.v1.response.vo.CommonResult;
import com.mentaldiary.mentalapi.v1.response.vo.ErrorResult;
import com.mentaldiary.mentalapi.v1.response.vo.SingleResult;
import com.mentaldiary.mentalapi.v1.user.service.UserService;
import com.mentaldiary.mentalapi.v1.user.vo.SignUpVO;
import com.mentaldiary.mentalapi.v1.user.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Api(tags = {"1. User"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;
    private final ResponseService responseService;

    // 로그인
    @PostMapping(value = "/signIn")
    @ApiOperation(value = "로그인", notes = "로그인을 합니다.")
    public CommonResult login(@ApiParam(value = "필수값 : email, pwssword", required = false)
                              @RequestBody SignUpVO signUpV0) throws Exception {

        UserVO userVo;

        try {
            userVo = userService.signIn(signUpV0);
        } catch (SignExeption e) {
            return responseService.getFailResult(-1,e.getMessage());
        }

        return responseService.getSuccessResult();
    }

    @PostMapping(value = "/signUp")
    @ApiOperation(value = "회원가입", notes = "회원가입을 한다.")
    public ErrorResult save(@Valid @RequestBody SignUpVO signUpV0, BindingResult result) {

        // 회원가입 실패 시,
        if (result.hasErrors()) {

            // 유효성 통과 못한 필드와 메시지를 핸들링
            Map<String, String> errorMsgs = new HashMap<>();

            for (FieldError error : result.getFieldErrors()) {
                errorMsgs.put(error.getField(), error.getDefaultMessage());
                System.out.println(error.getDefaultMessage());
            }

            return responseService.getErrorResult(errorMsgs);
        }

        userService.signUp(signUpV0);

        return responseService.getNonErrorResult();
    }

    @GetMapping
    @ApiOperation(value = "이메일 중복확인", notes = "이미 가입된 이메일이 있는지 확인합니다.")
    public CommonResult checkDuplicatedEmail(@ApiParam(value = "이메일", required = true)
                                             @RequestParam String email) {

        User user = userService.checkDuplicatedEmail(email);

        return user == null ? responseService.getSuccessResult() : responseService.getFailResult(-1, "이미 존재하는 이메일 입니다.");
    }


}
