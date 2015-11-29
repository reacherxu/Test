package org.dp.behavior.strategy;

public class Multiply extends AbstractCalculator implements ICalculator {

	@Override
	public int calculate(String exp) {
		int multi[] = split(exp,"\\*");
		return multi[0] * multi[1];
	}

}
