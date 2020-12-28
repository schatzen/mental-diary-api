package com.mentaldiary.mentalapi.v1.user.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"1. 유저"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/user")
public class UserController {

}
