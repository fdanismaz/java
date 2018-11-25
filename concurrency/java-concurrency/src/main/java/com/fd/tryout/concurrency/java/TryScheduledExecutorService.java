package com.fd.tryout.concurrency.java;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledExecutorService is similar to executor service, but it can perform tasks periodically
 *
 * @author fdanismaz
 * date: 11/24/18 2:07 PM
 */
public class TryScheduledExecutorService {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService s = Executors.newScheduledThreadPool(10);
        s.schedule(() -> System.out.println("Hello World!"), 1, TimeUnit.SECONDS);

        //s.shutdown(); // We cannot use the executor service after it is shutdown

        s.scheduleAtFixedRate(() -> System.out.println("Hello World 2"), 3, 1, TimeUnit.SECONDS);

        Thread.sleep(10000);
        s.shutdown();
        System.out.println("Program Finished");
    }
}
