package com.fd.tryout.aws.lambda.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.fd.tryout.aws.lambda.model.MyResponse;

import javax.inject.Inject;

/**
 * @author fdanismaz
 * date: 11/12/18 11:50 PM
 */
public class S3EventHandlerService {

    @Inject
    public S3EventHandlerService() {
    }

    public MyResponse handle(S3Event event, Context context) {
        String message = event.toString();
        return new MyResponse(message);
    }
}
