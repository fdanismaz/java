package com.fd.jackson.filter.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericResponse<T> {

    private T data;
    private boolean success;
    private String failureMessage;

    public static <T> GenericResponse<T> success(T data) {
        GenericResponse<T> response = new GenericResponse<>();
        response.data = data;
        response.success = true;
        return response;
    }

    public static <T> GenericResponse<T> fail(String failureMessage) {
        GenericResponse<T> response = new GenericResponse<>();
        response.failureMessage = failureMessage;
        response.success = false;
        return response;
    }
}
