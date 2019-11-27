package com.fcommons.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.TimeZone;

/**
 * @author fdanismaz
 * @since 11/26/19
 */
public class FRestController {

    @Autowired
    protected RequestContext requestContext;

    @Autowired
    protected Validator validator;

    @Autowired
    private FHttpResponseBuilder responseBuilder;

    /**
     * If you do not set validator to the {@link WebDataBinder}, you will get
     * message codes instead of local messages.
     * @param binder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    public <T> ResponseEntity<T> success(T data) {
        return this.responseBuilder.success(data);
    }

    public ResponseEntity<ResponseEntity<?>> success() {
        return this.responseBuilder.success();
    }

    protected HttpServletRequest request() {
        return this.requestContext.request();
    }

    protected HttpServletResponse response() {
        return this.requestContext.response();
    }

    protected TimeZone timeZone() {
        return this.requestContext.timeZone();
    }

}
