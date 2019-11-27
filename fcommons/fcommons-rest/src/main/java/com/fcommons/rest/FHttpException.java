package com.fcommons.rest;

import lombok.Getter;

/**
 * @author fdanismaz
 * @since 11/26/19
 */
@Getter
public class FHttpException extends RuntimeException {

    private int httpStatus;
    private String title;

    public FHttpException(String title) {
        super(title);
        this.httpStatus = 500;
        this.title = title;
    }

    public FHttpException(String title, int httpStatus) {
        super(title);
        this.httpStatus = httpStatus;
        this.title = title;
    }

    public FHttpException(String title, String message) {
        super(message);
        this.title = title;
        this.httpStatus = 500;
    }

    public FHttpException(String title, String message, int httpStatus) {
        super(message);
        this.title = title;
        this.httpStatus = httpStatus;
    }

    public FHttpException(String title, String message, Throwable cause) {
        super(message, cause);
        this.httpStatus = 500;
        this.title = title;
    }

    public FHttpException(String title, String message, Throwable cause, int httpStatus) {
        super(message, cause);
        this.httpStatus = httpStatus;
        this.title = title;
    }
}
