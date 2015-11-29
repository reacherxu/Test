package org.dp.structural.adapter;

public class Wrapper implements Adaptable {
	private Source source;
	
	
	public Wrapper(Source source) {
		super();
		this.source = source;
	}

	@Override
	public void method1() {
		source.method1();
	}

	@Override
	public void method2() {
		System.out.println("this is the targetable method!");  
	}

	
	public static void main(String[] args) {
		Adaptable a = new Wrapper(new Source());
		a.method1();
		a.method2();
	}
}
