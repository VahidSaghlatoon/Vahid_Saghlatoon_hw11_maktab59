package com.vahidsaghlatoon.q4;

public interface Buffer {
    public void blockingPut(int value) throws InterruptedException ;
    public int blockingGet() throws InterruptedException;
}
