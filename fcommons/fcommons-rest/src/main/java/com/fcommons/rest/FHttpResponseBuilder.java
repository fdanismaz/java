package com.fcommons.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

/**
 * @author fdanismaz
 * @since 11/26/19
 */
@Component
public class FHttpResponseBuilder {

    public ResponseEntity<ResponseEntity<?>> success() {
        return ResponseEntity.ok().build();
    }

    public <T> ResponseEntity<T> success(T data) {
        return ResponseEntity.ok().body(data);
    }

    public ResponseEntity<FErrorContainer> error(Exception exception, String errorTitle, int httpStatusCode) {
        FErrorContainer errorContainer = new FErrorContainer();
        errorContainer.addError(
                new FErrorItem(errorTitle, exception.getMessage(), FErrorType.Default.getValue()));
        return ResponseEntity.status(httpStatusCode).body(errorContainer);
    }

    public ResponseEntity<?> error(BindingResult bindingResult, int httpStatusCode) {
        FErrorContainer errorContainer = new FErrorContainer();

        for (ObjectError objectError : bindingResult.getGlobalErrors()) {
            FErrorItem error = new FErrorItem(objectError.getObjectName(),
                    objectError.getDefaultMessage(), FErrorType.Object.getValue());
            errorContainer.addError(error);
        }
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            FErrorItem error = new FErrorItem(fieldError.getField(),
                    fieldError.getDefaultMessage(), FErrorType.Field.getValue());
            errorContainer.addError(error);
        }
        return ResponseEntity.status(httpStatusCode).body(errorContainer);
    }
}
