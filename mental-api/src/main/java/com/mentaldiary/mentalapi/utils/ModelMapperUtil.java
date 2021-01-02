package com.mentaldiary.mentalapi.utils;


import org.modelmapper.ModelMapper;

public class ModelMapperUtil {

    // Bean은 스프링이 직접 관리하기 떄문에, Bean으로 등록하지 않고 다음과 같이 호출해서 사용
    private static ModelMapper modelMapper = new ModelMapper();

    public static ModelMapper getModelMapper() {
        return modelMapper;
    }
}
