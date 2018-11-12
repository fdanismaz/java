package com.fd.tryout.aws.lambda.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fd.tryout.aws.lambda.service.MyService;
import com.fd.tryout.aws.lambda.config.DaggerIocConfig;
import com.fd.tryout.aws.lambda.config.IocConfig;
import com.fd.tryout.aws.lambda.model.MyRequest;
import com.fd.tryout.aws.lambda.model.MyResponse;

/**
 * @author fdanismaz
 * date: 11/11/18 4:58 PM
 */
public class MySampleHandler implements RequestHandler<MyRequest, MyResponse> {

    private MyService myService;

    public MySampleHandler() {
        IocConfig ioc = DaggerIocConfig.create();
        this.myService = ioc.myService();
    }

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
