package org.dp.behavior.command;

public class MyCommand implements Command {

	private Receiver receiver;
	
	public MyCommand(Receiver receiver) {
		super();
		this.receiver = receiver;
	}

	@Override
	public void exe() {
		receiver.action();
	}

}
