package org.xzt.code;

//快速幂运算
public class Power {
	public double power(double x,int n) {
		double res = 1;
		while(n != 0) {
			if( (n & 1) == 1) {
				res *= x;
			}
			x *= x;
			n >>= 1;
			System.out.println("x:"+x+"  n:"+n +"  res:"+res);
		}
		return res;
	}
	public static void main(String[] args) {
		Power ins = new Power();
		System.out.println(ins.power(2,10));
	}
}
