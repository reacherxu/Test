package org.dp.behavior.strategy;

public class Minus extends AbstractCalculator implements ICalculator {

	@Override
	public int calculate(String exp) {
		int minus[] = split(exp,"\\-");
		return minus[0] - minus[1];
	}

}
