package com.fd.tryout.aws.lambda.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.fd.tryout.aws.lambda.config.DaggerIocConfig;
import com.fd.tryout.aws.lambda.config.IocConfig;
import com.fd.tryout.aws.lambda.model.MyResponse;
import com.fd.tryout.aws.lambda.service.S3EventHandlerService;

/**
 * @author fdanismaz
 * date: 11/12/18 11:42 PM
 */
public class MyS3PutEventHandler implements RequestHandler<S3Event, MyResponse> {

    private S3EventHandlerService service;

    public MyS3PutEventHandler() {
        IocConfig ioc = DaggerIocConfig.create();
        this.service = ioc.s3EventHandlerService();
    }

    @Override
    public MyResponse handleRequest(S3Event event, Context context) {
        return this.service.handle(event, context);
    }
}
