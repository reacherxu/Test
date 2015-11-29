package org.dp.creative.singleton;

public class Singleton {
	private volatile static Singleton instance = null;
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		synchronized (instance) {
			if(instance == null)
				instance = new Singleton();
			return instance;
		}
	}
}
