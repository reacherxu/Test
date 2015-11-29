package org.dp.creative.factory;

public class MailFactory implements Provider {

	@Override
	public Sender produce() {
		System.out.println("A mail created....");
		return new MailSender();
	}

}
