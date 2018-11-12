package com.fd.tryout.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fd.tryout.aws.lambda.model.MyRequest;
import com.fd.tryout.aws.lambda.model.MyResponse;

import javax.inject.Inject;

/**
 * @author fdanismaz
 * date: 11/11/18 4:58 PM
 */
public class MySampleHandler implements RequestHandler<MyRequest, MyResponse> {

    @Inject
    MyService myService;

    /**
     * Entry point
     * @param myRequest
     * @param context
     * @return
     */
    @Override
    public MyResponse handleRequest(MyRequest myRequest, Context context) {
        return this.myService.execute(myRequest, context);
    }
}
