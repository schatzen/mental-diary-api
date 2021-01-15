package com.mentaldiary.mentalapi.v1.response.service;


import com.mentaldiary.mentalapi.v1.response.vo.CommonResult;
import com.mentaldiary.mentalapi.v1.response.vo.ErrorResult;
import com.mentaldiary.mentalapi.v1.response.vo.ListResult;
import com.mentaldiary.mentalapi.v1.response.vo.SingleResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ResponseService {


    // enum으로 api 요청 결과에 대한 code, message를 정의합니다.
    public enum CommonResponse {
        SUCCESS(0, "성공하였습니다."), FAIL(-1, "실패하였습니다.");

        int code;
        String msg;

        CommonResponse(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    // 단일건 결과를 처리하는 메소드
    public <T> SingleResult<T> getSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        setSuccessResult(result);
        return result;
    }

//    public <T> SingleResult<T> getSingleFailResult(String msg) {
//        SingleResult<T> result = new SingleResult<>();
//        result.setData(null);
//        setFailResult(result, msg);
//        return result;
//    }

    // 다중건 결과를 처리하는 메소드
    public <T> ListResult<T> getListResult(List<T> list) {
        ListResult<T> result = new ListResult<>();
        result.setList(list);
        setSuccessResult(result);
        return result;
    }

    // 성공 결과만 처리하는 메소드
    public CommonResult getSuccessResult() {
        CommonResult result = new CommonResult();
        setSuccessResult(result);
        return result;
    }

    // 결과 모델에 api 요청 성공 데이터를 세팅해주는 메소드
    private void setSuccessResult(CommonResult result) {
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }

    // 결과 모델에 api 요청 실패 데이터를 세팅해주는 메소드
    private void setFailResult(CommonResult result, String msg) {
        result.setSuccess(false);
        result.setCode(CommonResponse.FAIL.getCode());
        result.setMsg(msg);
    }


    // 실패 결과만 처리하는 메소드
    public CommonResult getFailResult() {
        CommonResult result = new CommonResult();
        result.setSuccess(false);
        result.setCode(CommonResponse.FAIL.getCode());
        result.setMsg(CommonResponse.FAIL.getMsg());
        return result;
    }

    public CommonResult getFailResult(int code, String msg) {
        CommonResult result = new CommonResult();
        result.setSuccess(false);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }


    // Validation 통과 못한 결과 처리하는 메소드
    public ErrorResult getErrorResult(Map<String, String> map) {
        ErrorResult result = new ErrorResult();
        result.setSuccess(false);
        result.setCode(CommonResponse.FAIL.getCode());
        result.setErrorField((String) map.keySet().toArray()[0]);
        result.setMsg((String) map.values().toArray()[0]);

        return result;
    }

    public ErrorResult getErrorResult(String errorField, String msg) {
        ErrorResult result = new ErrorResult();
        result.setSuccess(false);
        result.setCode(CommonResponse.FAIL.getCode());
        result.setErrorField(errorField);
        result.setMsg(msg);

        return result;
    }

    // Validation 통과된 결과 처리하는 메소드
    public ErrorResult getNonErrorResult() {
        ErrorResult result = new ErrorResult();
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setErrorField("null");
        result.setMsg("성공하셨습니다.");

        return result;
    }
}
