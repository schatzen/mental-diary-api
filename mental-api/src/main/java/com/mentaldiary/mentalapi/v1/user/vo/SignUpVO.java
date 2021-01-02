package com.mentaldiary.mentalapi.v1.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
public class SignUpVO {

    @ApiModelProperty(value = "이메일", required = true)
    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "이메일 형식에 맞지 않습니다.")
    public String email;

    @ApiModelProperty(value = "생일", required = true)
    @NotBlank(message = "생일을 입력해주세요.")
    @Pattern(regexp = "([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|3[0,1]))", message = "6자리의 숫자만 입력가능합니다")
    public String birthdate;

    @ApiModelProperty(value = "성별 (0:남자, 1:여자)", required = true)
    @NotNull(message = "성별을 입력해주세요.")
    public Integer gender;

    @ApiModelProperty(value = "비밀번호", required = true)
    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#${'$'}%^&*()])[A-Za-z\\d!@#${'$'}%^&*()]{8,}$",
    message = "비밀번호는 영문 대소문자, 숫자, 특수문자를 포함한 8자 이상이어야 합니다.")
    public String password;



}
