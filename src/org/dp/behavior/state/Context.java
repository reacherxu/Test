package org.dp.behavior.state;

/**
 * @author Reacher
 *
 */
public abstract class Context {

	private State state;
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Context(State state) {
		this.state = state;
	}
	
	public abstract void method();
	
}
