package com.fd.tryout.aws.lambda;

import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.fd.tryout.aws.lambda.handler.MyS3PutEventHandler;
import com.fd.tryout.aws.lambda.handler.MySampleHandler;
import com.fd.tryout.aws.lambda.model.MyRequest;
import com.fd.tryout.aws.lambda.model.MyResponse;

import java.util.ArrayList;

/**
 * @author fdanismaz
 * date: 11/12/18 11:33 PM
 */
public class App {

    public static void main(String[] args) {
        MySampleHandler handler = new MySampleHandler();
        MyResponse response = handler.handleRequest(MyRequest.builder().name("furkan").surname("danismaz").build(), null);
        System.out.println(response);

        MyS3PutEventHandler handler2 = new MyS3PutEventHandler();
        MyResponse response2 = handler2.handleRequest(new S3Event(new ArrayList<>()), null);
        System.out.println(response2);
    }
}
