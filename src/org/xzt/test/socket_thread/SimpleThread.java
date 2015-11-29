package org.xzt.test.socket_thread;

import java.util.concurrent.ThreadFactory;

public class SimpleThread implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
		return  new Thread(r);
	}
}
