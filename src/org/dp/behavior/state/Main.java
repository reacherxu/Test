package org.dp.behavior.state;

public class Main {
	public static void main(String[] args) {
		State state = new State();
		Context context = new Context1(state);
		state.setValue("reacher");
		context.method();
		
		context = new Context2(state);
		state.setValue("angus");
		context.method();
	}
}
