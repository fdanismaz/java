package com.fd.tryout.concurrency.java;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author fdanismaz
 * date: 11/25/18 12:31 PM
 */
public class TrySemaphore {

    private static class Worker implements Runnable {

        private Semaphore semaphore;
        private int id;
        private CountDownLatch completedThreadCountdown;

        public Worker(int id, Semaphore semaphore, CountDownLatch completedThreadCountdown) {
            this.id = id;
            this.semaphore = semaphore;
            this.completedThreadCountdown = completedThreadCountdown;
        }

        @Override
        public void run() {
            System.out.println(String.format("Thread %d is ready. Waiting for permit.", this.id));
            //if (this.semaphore.tryAcquire()) {
                try {
                    this.semaphore.acquire();
                    System.out.println(String.format("Thread %d starting its job. Permit count: %d...", this.id, this.semaphore.availablePermits()));

                    // do the job
                    //Thread.sleep(2000);

                    synchronized (this.semaphore) {
                        this.semaphore.release();
                        System.out.println(String.format("Thread %d finished. Permit count: %d ", this.id, this.semaphore.availablePermits()));
                        this.completedThreadCountdown.countDown();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            //}
        }
    }

    private static int id = 1;

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        Semaphore semaphore = new Semaphore(5, true);
        CountDownLatch completedThreadCountdown = new CountDownLatch(threadCount);

        // Create threads
        List<? extends Runnable> workers = Stream
                .generate(() -> new Worker(id++, semaphore, completedThreadCountdown))
                .limit(threadCount)
                .collect(Collectors.toList());

        LocalDateTime startTime = LocalDateTime.now();

        // Start threads
        workers.forEach(w -> executorService.submit(w));

        completedThreadCountdown.await();

        LocalDateTime endTime = LocalDateTime.now();

        executorService.shutdown();
        System.out.println(String.format("Total work time: %s milliseconds", Duration.between(startTime, endTime).getNano() / 1000 / 1000));
    }
}
