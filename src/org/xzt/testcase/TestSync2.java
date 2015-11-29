package org.xzt.testcase;

public class TestSync2 implements Runnable {

	public int b = 100;
	public static void main(String[] args) throws InterruptedException {
		TestSync2 ts = new TestSync2();
		Thread t = new Thread(ts);
		t.start();
		
		Thread.sleep(1000);
		try {
			ts.m2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public void run() {
		try {
			m1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public synchronized void m1() throws Exception {
		b = 1000;
		Thread.sleep(2000);
		System.out.println("b="+b);
	}
	public synchronized void m2() throws Exception {
		b = 2000;
		Thread.sleep(2000);
		System.out.println(b);
	}

}
