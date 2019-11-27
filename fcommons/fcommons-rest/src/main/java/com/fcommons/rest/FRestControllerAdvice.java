package com.fcommons.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * @author fdanismaz
 * @since 11/26/19
 */
@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class FRestControllerAdvice {

    private final FHttpResponseBuilder responseBuilder;

    public FRestControllerAdvice(FHttpResponseBuilder responseBuilder) {
        this.responseBuilder = responseBuilder;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> runtimeException(Exception exception) {
        log.error(exception.getMessage(), exception);
        return this.responseBuilder.error(exception, "Server error", HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @ExceptionHandler(FHttpException.class)
    public ResponseEntity<?> runtimeException(FHttpException exception) {
        log.error(exception.getMessage(), exception);
        return this.responseBuilder.error(exception, exception.getTitle(), exception.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> invalidArgument(MethodArgumentNotValidException exception) {
        log.error(exception.getMessage(), exception);
        return this.responseBuilder.error(exception.getBindingResult(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> argumentTypeMismatch(MethodArgumentTypeMismatchException exception) {
        log.error(exception.getMessage(), exception);
        return this.responseBuilder.error(exception, "Invalid parameter", HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> missingParameter(MissingServletRequestParameterException exception) {
        log.error(exception.getMessage(), exception);
        return this.responseBuilder.error(exception, "Missing parameter", HttpStatus.BAD_REQUEST.value());
    }
}
