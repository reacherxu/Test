package org.dp.behavior.strategy;

public class Main {
	public static void main(String[] args) {
		ICalculator cal = new Multiply();
		System.out.println(cal.calculate("4*9"));
	}
}
