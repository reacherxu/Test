package org.dp.creative.factory;

public class FactoryTest {
	public static void main(String[] args) {
		Provider provider = new MailFactory();
		Sender send = provider.produce();
		send.send();
		/*//大多数情况下，我们会选用第三种——静态工厂方法模式。
		//静态工厂模式
		Sender send = SendFactory.produceMail();
		send.send();*/
		
		//多个工厂模式
		/*SendFactory factory = new SendFactory();
		Sender sender = factory.produceMail();
		sender.send();
		sender = factory.produceSms();
		sender.send();*/
		
		//简单工厂模式
		/*SendFactory factory = new SendFactory();
		Sender sender = factory.produce("mail");
		sender.Send();
		
		sender = factory.produce("sms");
		sender.Send();
		
		sender = factory.produce("line");*/
	}
}
