package com.fd.tryout.dagger.config;

import com.fd.tryout.dagger.MyService;
import com.fd.tryout.dagger.MyService2;
import dagger.Component;

import javax.inject.Singleton;

/**
 * @author fdanismaz
 * date: 11/11/18 7:15 PM
 */
@Singleton
@Component(modules = SampleDaggerModule.class)
public interface IoCConfig {

    MyService myService();

    MyService2 myService2();
}
