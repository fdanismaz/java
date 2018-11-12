package com.fd.tryout.aws.lambda.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.fd.tryout.aws.lambda.model.MyRequest;
import com.fd.tryout.aws.lambda.model.MyResponse;

import javax.inject.Inject;

/**
 * @author fdanismaz
 * date: 11/11/18 5:13 PM
 */
public class MyService {

    @Inject
    public MyService() {
    }

    public MyResponse execute(MyRequest request, Context context) {
        String greetings = String.format("Hello %s %s", request.getName(), request.getSurname());
        return new MyResponse(greetings);
    }
}
