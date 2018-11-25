package com.fd.tryout.concurrency.java;

/**
 * @author fdanismaz
 * date: 11/25/18 4:36 PM
 */
public class TryDaemonThread {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A Daemon thread!");
        });

        t.setDaemon(true);
        t.start();

        System.out.println("Program finished...");
    }
}
