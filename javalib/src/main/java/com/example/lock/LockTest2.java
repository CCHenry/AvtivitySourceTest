package com.example.lock;

/**
 * 读和写不能同时进行
 */
public class LockTest2 {
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

class Data {
	public String value = "";

	public synchronized void setValue(String value) {
        System.out.println(Thread.currentThread().getName() + " prepare write value="+value);
		this.value = value;
		System.out.println(Thread.currentThread().getName() + " has write value="+value);

	}

	public synchronized void  getValue() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + " prepare read value");
		System.out.println(Thread.currentThread().getName() + " read value="+value);
		System.out.println(Thread.currentThread().getName() + " has read value");

	}
}