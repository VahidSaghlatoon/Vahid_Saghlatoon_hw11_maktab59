package com.vahidsaghlatoon.q1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedResourceTest {
    public static void main(String[] args) throws InterruptedException {
        int num = 10 ;
        SharedResource sharedResource = new SharedResource();
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new AddEven(num , sharedResource));
        executorService.execute(new AddOdd(num , sharedResource));

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println(sharedResource);
    }
}
