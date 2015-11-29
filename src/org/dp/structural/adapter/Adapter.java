package org.dp.structural.adapter;

public class Adapter extends Source implements Adaptable {

	public void method2() {
		System.out.println("this is the Adaptable method!");  
	}
	public static void main(String[] args) {
		Adaptable adaptable = new Adapter();
		adaptable.method1();
		adaptable.method2();
	}
}
