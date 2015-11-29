package org.xzt.test;

public class Test1 { 
	public static void main(String[] args) {  
		System.out.println("reture value of test() : " + getValueII()); 
	} 
	public static int test(){ 
		@SuppressWarnings("unused")
		int i = 1; 
		try {  
			System.out.println("try block");  
			i = 1 / 0; 
			return 1;  
		}catch (Exception e){ 
			System.out.println("exception block"); 
			return 2; 
		}finally {  
			System.out.println("finally block");  
		} 
	} 
	
	
	//return 1
	public static int getValueII() { 
		int i = 1; 
		try { 
			return i; 
		} finally { 
			i++; 
		} 
	} 
	
}