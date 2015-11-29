package org.dp.behavior.strategy;

public class Plus extends AbstractCalculator implements ICalculator {

	@Override
	public int calculate(String exp) {
		int[] add = split(exp,"\\+");
		return add[0]+add[1];
	}

}
