package com.fd.tryout.dagger.config;

import com.fd.tryout.dagger.MyBusinessLogic;
import com.fd.tryout.dagger.MyService;
import com.fd.tryout.dagger.MyServiceImpl;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * @author fdanismaz
 * date: 11/11/18 7:17 PM
 */
@Module
public class SampleDaggerModule {

    @Provides
    @Singleton
    public static MyService provideMyService() {
        return new MyServiceImpl(new MyBusinessLogic());
    }

}
