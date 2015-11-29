package org.dp.structural.adapter;

public class Main {
	public static void main(String[] args) {
		Adaptable s1 = new Source1();
		Adaptable s2 = new Source2();
		
		s1.method1();
		s1.method2();
		
		s2.method1();
		s2.method2();
	}
}
