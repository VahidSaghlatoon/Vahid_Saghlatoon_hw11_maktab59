package com.vahidsaghlatoon.q1;

import java.util.ArrayList;
import java.util.List;

public class SharedResource {
    private final List<Integer> integerList;
    private boolean occupied ;

    public SharedResource() {
        integerList = new ArrayList<>();
        occupied = false ;
    }

    public synchronized void integerListPut(int value) throws InterruptedException {
        while (occupied){
            System.out.println(Thread.currentThread().getName() + " waiting ... ");
            wait();
        }
        integerList.add(value);
        occupied = true ;
        notifyAll();
    }

    public synchronized void integerListPutOdd(int value) throws InterruptedException {
        while (!occupied){
            System.out.println(Thread.currentThread().getName() + " waiting ... ");
            wait();
        }
        integerList.add(value);
        occupied = false ;
        notifyAll();
    }

    @Override
    public String toString() {

        return "SharedResource{" +
                "integerList=" + integerList +
                '}';
    }
}
