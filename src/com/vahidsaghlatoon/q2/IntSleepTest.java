package com.vahidsaghlatoon.q2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class IntSleepTest {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Thread main start");
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Thread thread = new Thread(new IntSleep());
        thread.start();
        boolean b = executorService.awaitTermination(2, TimeUnit.SECONDS);
        thread.interrupt();
        System.out.println("main thread finished");

    }


}
