package com.vahidsaghlatoon.q4;

import java.security.SecureRandom;

public class Producer implements Runnable {
    private final Buffer sharedLocation;
    private final SecureRandom generator = new SecureRandom();

    public Producer(Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(generator.nextInt(3000));
                sharedLocation.blockingPut(i);
                sum += i;
                System.out.println(" sum is : " + sum);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("producer done producing terminating producer");
    }
}
