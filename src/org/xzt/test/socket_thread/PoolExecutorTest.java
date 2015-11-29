package org.xzt.test.socket_thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Task {  
	public void fun() {  
		for (int i = 0; i < 10; i++) {  
			System.out.println(Thread.currentThread().getName() + " 执行 - " + i);  
		}  
	}  
}  
public class PoolExecutorTest {
	public static void main(String[] args) {
		final Task task = new Task();  
		//synchronousqueue
		/*ThreadPoolExecutor pool = new 
				ThreadPoolExecutor(2, 3, 3L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(),new ThreadPoolExecutor.AbortPolicy());
		for (int i = 0; i < 3; i++) {
			pool.execute(new Runnable() {

				@Override
				public void run() {
					task.fun();
					System.out.println("run");  
				}
			});
		}
		pool.shutdown();*/
		
		//blockingqueue  LinkedBlockingQueue  ArrayBlockingQueue
		ThreadPoolExecutor pool =   
				new ThreadPoolExecutor(2, 4, 3L,   
						TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(1), new ThreadPoolExecutor.AbortPolicy());  
		for (int i = 0; i < 5; i++) {  
			pool.execute(new Runnable() {  
				@Override  
				public void run() {  
					task.fun();  
					System.out.println("run");  
				}  
			});  
		}  
		pool.shutdown();  
	}
}
