package org.dp.structural.decorator;

public class Decorator implements Sourceable {
	
	Sourceable source;
	
	public Decorator(Sourceable source) {
		super();
		this.source = source;
	}
	
	@Override
	public void method() {
		System.out.println("before decorator!");  
        source.method();  
        System.out.println("after decorator!");  
	}
	
	public static void main(String[] args) {
		Sourceable source = new Decorator(new Source());
		source.method();
	}
}
