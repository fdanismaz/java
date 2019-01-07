package com.fd.tryout.concurrency.java;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This is a very nice example of using CountDownLatch. In this code we generate 15 threads, start them but
 * block them all until all the threads get into their run method. Fire the begin sign, and wait until
 * all the workers finish their job.
 *
 * @author fdanismaz
 * date: 11/24/18 11:18 PM
 */
public class PoolOfThreadsWaitingToBegin {

    private static class Worker implements Runnable {

        private int id;
        private CountDownLatch readyThreadCounter;
        private CountDownLatch launcherBlocker;
        private CountDownLatch completedThreadCounter;


        public Worker(int id, CountDownLatch readyThreadCounter,
                      CountDownLatch launcherBlocker, CountDownLatch completedThreadCounter) {
            this.id = id;
            this.readyThreadCounter = readyThreadCounter;
            this.launcherBlocker = launcherBlocker;
            this.completedThreadCounter = completedThreadCounter;
        }

        @Override
        public void run() {
            // Thread is ready. Countdown
            System.out.println(String.format("Worker %d is ready", this.id));
            this.readyThreadCounter.countDown();

            // Wait for other threads to be ready
            try {
                this.launcherBlocker.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // do work
            System.out.println(String.format("Running job %d", this.id));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Thread has completed its job, countdown
            this.completedThreadCounter.countDown();
        }
    }

    private static CountDownLatch readyThreadCounter = new CountDownLatch(15);
    private static CountDownLatch launcherBlocker = new CountDownLatch(1);
    private static CountDownLatch completedThreadCounter = new CountDownLatch(15);

    public static int id = 1;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService s = Executors.newCachedThreadPool();
        System.out.println("Genearting threads...");
        List<? extends Runnable> workerList = Stream
                .generate(() -> new Worker(id++, readyThreadCounter, launcherBlocker, completedThreadCounter))
                .limit(15)
                .collect(Collectors.toList());

        workerList.forEach(worker -> s.submit(worker));
        System.out.println("Threads are generated, waiting for them to become ready...");
        readyThreadCounter.await(); // Wait until all threads get in their run method
        System.out.println("All threads are ready");

        // all threads are waiting for the begin sign, so let's start the threads
        Thread.sleep(5000);
        System.out.println("Firing the begin sign...");
        launcherBlocker.countDown();

        completedThreadCounter.await();
        // all threads have completed their work
        System.out.println("All the workers completed their jobs");

        s.shutdown();

    }
}
