package org.dp.structural.decorator;

public class Proxy implements Sourceable {
	Sourceable source;
	
	
	public Proxy(Sourceable source) {
		super();
		this.source = source;
	}


	@Override
	public void method() {
		before();
		source.method();
		after();
	}


	private void after() {
		 System.out.println("after proxy!");  
	}


	private void before() {
		 System.out.println("before proxy!");  
	}

	public static void main(String[] args) {
		Sourceable source = new Proxy(new Source());
		source.method();
	}
}
