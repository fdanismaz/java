package com.fd.tryout.dagger;

import com.fd.tryout.dagger.config.DaggerIoCConfig;
import com.fd.tryout.dagger.config.IoCConfig;

/**
 * @author fdanismaz
 * date: 11/11/18 7:15 PM
 */
public class App {

    public static void main(String[] args) {
        IoCConfig iocConfig = DaggerIoCConfig.create();

        MyService myService = iocConfig.myService();
        myService.print();

        MyService2 myService2 = iocConfig.myService2();
        myService2.print2();
    }
}
