package org.lc.math;

public class DivideTwoIntegers {

	public int divide(int dividend, int divisor) {
		if (divisor == 0)
			return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;

		boolean flag = (dividend ^ divisor) >>> 31 == 1;
		long dvd = Math.abs((long)dividend);//overflow
		long dvr = Math.abs((long)divisor);
		
		int a = 0;
		while (dvr<<(a+1)  <= dvd ) 
			a++;

		int res = 0;
		while (a >= 0) {
			if (dvd >= (dvr << a)) {
				res += 1 << a;
				dvd -= dvr << a;
			}
			a--;
		}
		return flag == true ? 0 - res : res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DivideTwoIntegers ins = new DivideTwoIntegers();
		System.out.println(ins.divide(-2147483648, -1));
	}

}
