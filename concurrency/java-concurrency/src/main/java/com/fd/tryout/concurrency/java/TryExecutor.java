package com.fd.tryout.concurrency.java;

import java.util.concurrent.Executor;

/**
 * Executor is an interface that represents an object that executes provided tasks.
 *
 * It depends on the particular implementation if the task should be run on a new or current thread
 *
 * @author fdanismaz
 * date: 11/24/18 9:58 AM
 */
public class TryExecutor {
    public static void main(String[] args) {
        Executor e = command -> command.run();
        e.execute(() -> System.out.println("Hello World!"));
        System.out.println("Program finished...");
    }
}
