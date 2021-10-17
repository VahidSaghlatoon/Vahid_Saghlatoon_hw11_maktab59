package com.vahidsaghlatoon.q4;

public class UnsynchronizedBuffer implements Buffer {
    private int buffer;

    public UnsynchronizedBuffer() {
        buffer = -1;
    }

    @Override
    public void blockingPut(int value) throws InterruptedException {
        System.out.println("producer write : " + value);
        buffer = value;
    }

    @Override
    public int blockingGet() throws InterruptedException {
        System.out.println("consumer read : " + buffer);
        return buffer;
    }
}
