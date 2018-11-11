package com.fd.tryout.dagger;

import javax.inject.Inject;

/**
 * @author fdanismaz
 * date: 11/11/18 7:17 PM
 */
public class MyServiceImpl implements MyService {

    MyBusinessLogic businessLogic;

    public MyServiceImpl(MyBusinessLogic businessLogic) {
        this.businessLogic = businessLogic;
    }

    @Override
    public void print() {
        this.businessLogic.print();
    }
}
