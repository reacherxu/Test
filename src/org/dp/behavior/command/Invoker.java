package org.dp.behavior.command;

public class Invoker {
	private Command command;

	public Invoker(Command command) {
		super();
		this.command = command;
	}
	
	public void invoke() {
		command.exe();
	}
	
	public static void main(String[] args) {
		Invoker invoker = new Invoker(new MyCommand(new Receiver()));
		invoker.invoke();
	}
	
}
