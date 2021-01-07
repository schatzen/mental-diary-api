package com.mentaldiary.mentalapi.v1.category.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class PostVo {


    public Long id;
    public String content;
}
