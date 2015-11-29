package org.dp.creative.factory;

import java.util.ArrayList;
import java.util.List;

public class Builder {
	private List<Sender> list = new ArrayList<Sender>(); 
	
	public void produceMail(int count) {
		for (int i = 0; i < count; i++) {
			Sender send = new MailFactory().produce();
			list.add(send );
		}
	}
	
	public void produceSms(int count) {
		for (int i = 0; i < count; i++) {
			Sender send = new SmsFactory().produce();
			list.add(send );
		}
	}
	
	public static void main(String[] args) {
		Builder build = new Builder();
		build.produceMail(2);
		build.produceSms(3);
		System.out.println();

	}
}
