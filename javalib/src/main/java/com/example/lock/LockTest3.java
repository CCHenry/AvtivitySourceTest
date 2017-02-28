package com.example.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static com.example.lock.LockTest3.rwl;

/**
 * 读可以同时进行，写不同时进行
 */
public class LockTest3 {
    public static ReadWriteLock rwl = new ReentrantReadWriteLock();
    public static void main(String[] args) {
        final Data3 data = new Data3();
        new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    int finalI = i;
                    new Thread(){
                        @Override
                        public void run() {
                            data.setValue(finalI + "");
                        }
                    }.start();
                }
            };
        }.start();
        new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    int finalI = i;
                    new Thread(){
                        @Override
                        public void run() {
                            data.getValue();
                        }
                    }.start();
                }
            };
        }.start();
    }
}

class Data3 {
    public String value = "";

    public  void setValue(String value) {
        rwl.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + " prepare write value="+value);
        this.value = value;
        System.out.println(Thread.currentThread().getName() + " has write value="+value);
        rwl.writeLock().unlock();

    }

    public  void  getValue() {
        // TODO Auto-generated method stub
        rwl.readLock().lock();
        System.out.println(Thread.currentThread().getName() + " prepare read value");
        System.out.println(Thread.currentThread().getName() + " read value="+value);
        System.out.println(Thread.currentThread().getName() + " has read value");
        rwl.readLock().unlock();

    }
}