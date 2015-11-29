package org.dp.behavior.state;

public class Context1 extends Context {

	public Context1(State state) {
		super(state);
	}

	@Override
	public void method() {
		getState().method1();
	}

}
