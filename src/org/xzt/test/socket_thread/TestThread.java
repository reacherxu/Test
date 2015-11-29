package org.xzt.test.socket_thread;


public class TestThread {
	
	
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			
			public void run() {
				Count count = new Count();
				count.count();
			}
		};
		for (int i = 0; i < 100; i++) {
			new Thread(r).start();
		}
	}
}
