package com.fd.jackson.filter.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseBody<T> {

    private T data;
    private boolean success;
    private String failureMessage;

    public static <T> ResponseBody<T> success(T data) {
        ResponseBody<T> response = new ResponseBody<>();
        response.data = data;
        response.success = true;
        return response;
    }

    public static <T> ResponseBody<T> fail(String failureMessage) {
        ResponseBody<T> response = new ResponseBody<>();
        response.failureMessage = failureMessage;
        response.success = false;
        return response;
    }
}
