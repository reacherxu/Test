package org.xzt.testcase;

public class TestThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Th t = new Th();
		//t.run(); //����൱�ڷ�������
		
		//Thread thread = new Thread(t);
		t.start();
		
		for(int i =0 ;i < 10 ; i++) {
			System.out.println("Main :"+i);
		}
		
	}

}
 
//class Th implements Runnable {
class Th extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i =0 ;i < 10 ; i++) {
			System.out.println("T :"+i);
		}
	}
	
}