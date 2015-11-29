package org.xzt.test;

/**
 * 生产苹果线程
 */
class PutThread implements Runnable {
	private PublicApple apple;

	public PutThread(PublicApple apple) {
		this.apple = apple;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			apple.increace();
		}
	}
}

/**
 * 消费苹果线程
 */
class GetThread implements Runnable {
	private PublicApple apple;

	public GetThread(PublicApple apple) {
		this.apple = apple;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			apple.decreace();
		}
	}
}
/**
 * 公共资源类
 */
public class PublicApple {
	private int number = 0;

	/**
	 * 增加苹果数量
	 */
	public synchronized void increace() {
		while (number >= 5) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		number++;
		System.out.println(number);
		notify();
	}

	/**
	 * 减少苹果数量
	 */
	public synchronized void decreace() {
		while (number == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		number--;
		System.out.println(number);
		notify();
	}
	
	public static void main(String[] args) {
		PublicApple apple = new PublicApple();
		new Thread(new PutThread(apple)).start();
		new Thread(new GetThread(apple)).start();
	}
}
