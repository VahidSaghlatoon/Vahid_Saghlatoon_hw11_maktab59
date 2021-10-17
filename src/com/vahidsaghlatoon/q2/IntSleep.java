package com.vahidsaghlatoon.q2;

public class IntSleep implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 50; i++) {
                System.out.println("Hello");
                Thread.sleep(100);
            }
        } catch (InterruptedException ex) {
            System.out.println("Interrupted Exception occur");
        }
    }

}
