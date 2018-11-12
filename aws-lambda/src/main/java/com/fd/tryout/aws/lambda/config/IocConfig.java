package com.fd.tryout.aws.lambda.config;

import com.fd.tryout.aws.lambda.service.MyService;
import com.fd.tryout.aws.lambda.service.S3EventHandlerService;
import dagger.Component;

/**
 * @author fdanismaz
 * date: 11/12/18 11:32 PM
 */
@Component
public interface IocConfig {

    MyService myService();

    S3EventHandlerService s3EventHandlerService();
}
