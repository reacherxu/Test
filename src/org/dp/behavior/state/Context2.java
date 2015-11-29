package org.dp.behavior.state;

public class Context2 extends Context {

	public Context2(State state) {
		super(state);
	}

	@Override
	public void method() {
		getState().method2();
	}

}
