package com.fd.tryout.concurrency.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExecutorService is a complete solution for asynchronous processing. It manages an in-memory queue and
 * schedules submitted tasks based on thread availability.
 *
 * shutdown() - waits till all submitted tasks are finished
 * shutdownNow() - immediately terminates all the pending/executing tasks
 *
 * @author fdanismaz
 * date: 11/24/18 9:57 AM
 */
public class TryExecutorService {

    public static void main(String[] args) {
        ExecutorService s = Executors.newFixedThreadPool(5);
        Runnable r = () -> System.out.println("Hello world!");
        s.submit(r);
        s.submit(r);
        s.submit(r);
        s.submit(r);
        s.submit(r);
        s.submit(r);
        s.submit(r);
        s.submit(r);
        s.submit(r);
        s.submit(r);
        s.submit(r);
        s.submit(r);
        s.submit(r);
        s.submit(r);
        s.submit(r);
        System.out.println("Program finished...");
        s.shutdown();
    }
}
