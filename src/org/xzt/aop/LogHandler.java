package org.xzt.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Logger;

public class LogHandler implements InvocationHandler {

	private Logger logger = Logger.getLogger(this.getClass().getName());

	private Object delegate;

	public LogHandler(Object delegate){
		this.delegate = delegate;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object o = null;
		try {            

			logger.info("method stats..." + method);
			o = method.invoke(delegate,args);
			logger.info("method ends..." + method);

		} catch (Exception e){         
			logger.info("Exception happends...");
			//excetpion handling.
		}
		return o;
	}
	
	public static void main(String[] args) {
		BusinessInterface bi = new BusinessObject();
		InvocationHandler handler = new LogHandler(bi);
		BusinessInterface proxy = (BusinessInterface) Proxy.newProxyInstance(bi.getClass().getClassLoader(),
	            						bi.getClass().getInterfaces(), handler);

		proxy.processBusiness();
	}

}
