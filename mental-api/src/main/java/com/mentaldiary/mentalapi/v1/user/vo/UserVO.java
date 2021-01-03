package com.mentaldiary.mentalapi.v1.user.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserVO {

    public String email;
    public String birthdate;
    public Integer gender;
    public String password;
    public List<String> roles;

}
