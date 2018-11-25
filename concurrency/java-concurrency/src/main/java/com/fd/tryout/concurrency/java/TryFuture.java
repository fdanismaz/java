package com.fd.tryout.concurrency.java;

import java.util.concurrent.*;

/**
 * @author fdanismaz
 * date: 11/24/18 10:05 PM
 */
public class TryFuture {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService s = Executors.newScheduledThreadPool(5);

        // Start after 3 seconds, wait for 10 seconds and return John Doe
        Future<String> asyncResult = s.schedule(() -> {
            Thread.sleep(10000);
            return "Jonh Doe";
        }, 3, TimeUnit.SECONDS);

        // Wait for the job to be completed
        while (!asyncResult.isDone() && !asyncResult.isCancelled()) {
            System.out.println("Waiting for the job to be completed...");
            Thread.sleep(1000);
        }

        try {
            System.out.println(asyncResult.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        s.shutdown();

    }
}
