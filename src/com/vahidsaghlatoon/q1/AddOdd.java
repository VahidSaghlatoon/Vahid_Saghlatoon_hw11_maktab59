package com.vahidsaghlatoon.q1;

public class AddOdd implements Runnable {
    private final int num;
    private final SharedResource sharedResource;

    public AddOdd(int num, SharedResource sharedResource) {
        this.num = num;
        this.sharedResource = sharedResource;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i <= num; i++) {
            if (i % 2 != 0) {
                try {
                    sharedResource.integerListPutOdd(i);
                    System.out.println(Thread.currentThread().getName() + "-> wrote : " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
