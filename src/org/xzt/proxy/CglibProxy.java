package org.xzt.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	@Override
	public Object intercept(Object target, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("before-------------");
		Object res = proxy.invokeSuper(target, args);
		System.out.println("After--------------");
		return res;
	}

}
