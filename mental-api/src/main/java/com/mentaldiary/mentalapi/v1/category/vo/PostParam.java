package com.mentaldiary.mentalapi.v1.category.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostParam {

    @ApiModelProperty(value = "내용", required = true)
    private String content;
}
