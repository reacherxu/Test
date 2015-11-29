package org.xzt.test;

import org.xzt.test.socket_thread.SimpleThread;

public class TestVolatile {
	public static volatile int count = 0;
	public static synchronized void increment() {
		count ++;
	}
	public static void main(String[] args) {
		Thread[] threads = new Thread[20];
		for (int i = 0; i < threads.length; i++) {
			SimpleThread st = new SimpleThread();
			Runnable r = new Runnable(){
				@Override
				public void run() {
					for (int j = 0; j < 10000; j++) {
						increment();
					}
				}
			};
			threads[i] = st.newThread(r);
			threads[i].start();
		}
		while( Thread.activeCount() > 1) {
			Thread.yield();
		}
		System.out.println(count);
	}
}
