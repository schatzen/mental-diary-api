package com.mentaldiary.mentalapi.advice.exception;

public class SignExeption extends RuntimeException{


    // 로그인 시 발생하는 에러
    public SignExeption() {
    }

    public SignExeption(String message) {
        super(message);
    }


}
