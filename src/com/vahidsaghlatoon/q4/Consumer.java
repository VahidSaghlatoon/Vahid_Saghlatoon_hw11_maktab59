package com.vahidsaghlatoon.q4;

import java.security.SecureRandom;

public class Consumer implements Runnable {
    private Buffer sharedLocation;
    private SecureRandom dgenerator = new SecureRandom();

    public Consumer(Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(dgenerator.nextInt(3000));
                sum += sharedLocation.blockingGet();
                System.out.println(" Sum is : " + sum);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }

        }
        System.out.println("Consumer read value totaling : " + sum + " terminating consumer");
    }
}
