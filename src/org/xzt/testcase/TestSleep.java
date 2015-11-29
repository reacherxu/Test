package org.xzt.testcase;

import java.util.*;

public class TestSleep {

	public static void main(String[] args) {
		MyThread mt = new MyThread("xzt");
		mt.start();
		
		try {
			//Thread.sleep(3000);
			//mt.flag = false;
			mt.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mt.interrupt();
		for(int i=1; i<=10 ;i++) {
			System.out.println("Main method"+i);
		}
	}

}

/*class MyThread implements Runnable {
	public void run(){
	    while(true){
	      System.out.println("==="+new Date()+"===");
	      try {
	        Thread.sleep(1000);
	      } catch (InterruptedException e) {
	        return;
	      }
	    }
		
	}
	
}*/
class MyThread extends Thread {
	public boolean flag = true;
	public MyThread(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public void run(){
		while(flag){
	      System.out.println("==="+new Date()+"===");
	      try {
	        sleep(1000);
	      } catch (InterruptedException e) {
	        return;
	      }
	    }
		
	}
	
}