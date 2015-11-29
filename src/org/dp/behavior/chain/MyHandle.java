package org.dp.behavior.chain;

public class MyHandle extends AbstractHandle implements Handle {

	private String name;  
	 
	public MyHandle(String name) {
		super();
		this.name = name;
	}

	@Override
	public void operation() {
		System.out.println(name+"deal!");  
		Handle handle = getHandle();
		if( handle != null)
			handle.operation();
	}
	
	public static void main(String[] args) {
		MyHandle h1 = new MyHandle("h1");
		MyHandle h2 = new MyHandle("h2");
		MyHandle h3 = new MyHandle("h3");
		
		h1.setHandle(h2);
		h2.setHandle(h3);
		h1.operation();
		
	}

}
