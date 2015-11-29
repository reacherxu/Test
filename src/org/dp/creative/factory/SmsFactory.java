package org.dp.creative.factory;

public class SmsFactory implements Provider {

	@Override
	public Sender produce() {
		System.out.println("A sms created....");
		return new SmsSender();
	}

}
