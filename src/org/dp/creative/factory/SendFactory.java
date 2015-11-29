package org.dp.creative.factory;

public class SendFactory {
	//静态工厂方法
	public static Sender produceMail() {
		return new MailSender();  
	}
	public static Sender produceSms() {
		return new SmsSender();  
	}

	/*//多个工厂方法模式
	public Sender produceMail() {
		return new MailSender();  
	}
	public Sender produceSms() {
		return new SmsSender();  
	}*/

	//简单工厂方法    如果传递的字符串出错，则不能正确创建对象
	public Sender produce(String type) {
		if("mail".equals(type))
			return new MailSender();
		else if("sms".equals(type))
			return new SmsSender();
		else {
			System.out.println("请输入正确的类型!");  
			return null;  
		}

	}
}
