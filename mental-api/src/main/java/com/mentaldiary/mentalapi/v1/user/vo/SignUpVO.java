package com.mentaldiary.mentalapi.v1.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpVO {

    @ApiModelProperty(value = "이메일", required = true)
    private String email;

    @ApiModelProperty(value = "비밀번호", required = true)
    private String password;

    @ApiModelProperty(value = "성별 (0:남자, 1:여자)", required = true)
    private int gender;
}
