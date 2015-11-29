package org.xzt.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;



public class Reflection {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException {
/*		Person p = new Person();
		Class<?> cls = p.getClass();
		Person person1 = (Person) cls.newInstance();  //一定要有无参的构造函数
		person1.setAge(24);
		person1.setName("Reacher");
		System.out.println(person1);
		
		cls = Person.class;
		Person person2 = (Person) cls.newInstance();
		person2.setAge(24);
		person2.setName("Majie");
		System.out.println(person2);*/
		
		Class<?> cls =  Class.forName("org.xzt.test.SuperMan");
//		person3.setAge(25);
//		person3.setName("CHEN");
		
		System.out.println(cls.getSuperclass().getName());
		Field[] fields = cls.getFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i] );
		}
		Method[] methods = cls.getMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.println(methods[i]);
		}
		
		Method method = cls.getMethod("walk", int.class);
		try {
			method.invoke(cls.newInstance(), 100);
			method = cls.getMethod("fly");
			method.invoke(cls.newInstance() );
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
}
