package com.vahidsaghlatoon.q4;

public class SynchronizedBuffer implements Buffer {

    private int buffer;
    private boolean occupied;

    public SynchronizedBuffer() {
        buffer = -1;
        occupied = false;
    }

    @Override
    public synchronized void blockingPut(int value) throws InterruptedException {

        while (occupied) {
            System.out.printf("buffer is full-> buffer : %d ->occupied : %s%n ", buffer, occupied);
            wait();
        }
        buffer = value;
        occupied = true;
        System.out.println("producer writes");
        notifyAll();

    }

    @Override
    public synchronized int blockingGet() throws InterruptedException {
        while (!occupied) {
            System.out.println("consumer tried to read");
            wait();
        }
        occupied = false;
        System.out.println("consumer read value : " + buffer);
        notifyAll();
        return buffer;
    }
}
