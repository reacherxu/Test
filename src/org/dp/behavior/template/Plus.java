package org.dp.behavior.template;

public class Plus extends AbstractCalculator {

	@Override
	public int calculate(int a, int b) {
		return a + b;
	}

	public static void main(String[] args) {
		AbstractCalculator cal = new Plus();
		System.out.println(cal.calculate("1+8", "\\+"));
	}
}
