package org.lc.util;

public class Factorial {
	public static  long factorial(int n) {
		if( n <= 1)
			return 1;
		else
			return n*factorial(n-1);
	}
	
	public static  double factorialI(int n) {
		double res = 1;
		for(int i=1;i<=n ;i++)
			res *= i;
		return res;
	}
	
	public static void main(String[] args) {
		int n = 25;
//		System.out.println(factorial(n));
		System.out.println(factorialI(n));
	}

}
