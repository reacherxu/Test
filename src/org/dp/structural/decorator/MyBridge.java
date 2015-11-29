package org.dp.structural.decorator;

public class MyBridge extends Bridge {

	public MyBridge(Sourceable source) {
		super(source);
	}
	
	public static void main(String[] args) {
		Bridge bridge = new MyBridge(new SourceSub1());
		bridge.getSource().method();
	}
}
