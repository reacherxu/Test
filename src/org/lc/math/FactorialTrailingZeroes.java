package org.lc.math;

/**
 * Factorial Trailing Zeroes 
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
 * @author Reacher
 *
 */
public class FactorialTrailingZeroes {
	public static int trailingZeroes(int n) {
		int res = 0;
		while ( n != 0) {
			res += n / 5;
			n /= 5;
		}
		return res;

	}
	public static  int trailingZeroesI(int n) {
		int res = 0;
		while( n!=0 )
		{
			res += n/5;
			n /= 5;
		}
		return res;
	}
	public static void main(String[] args) {
		int n = 25;
		System.out.println(trailingZeroes(n));
		System.out.println(trailingZeroesI(n));
	}
}
