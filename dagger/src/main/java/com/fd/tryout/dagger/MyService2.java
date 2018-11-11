package com.fd.tryout.dagger;

import javax.inject.Inject;

/**
 * @author fdanismaz
 * date: 11/11/18 7:32 PM
 */
public class MyService2 {

    @Inject
    public MyService2() {
    }

    public void print2() {
        System.out.println("Hello World 2! from Dagger 2...");
    }
}
