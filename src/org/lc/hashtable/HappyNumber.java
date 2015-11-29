package org.lc.hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process:
Starting with any positive integer, 
replace the number by the sum of the squares of its digits, 
and repeat the process until the number equals 1 (where it will stay),
 or it loops endlessly in a cycle which does not include 1. 
 Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 * @author Reacher
 *
 */
public class HappyNumber {
	public boolean isHappy(int n) {
		if( n <= 0)
			return false;
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(n);
		
		while( n != 1) {
			int sum = 0;
			while( n != 0) {
				int bit = n%10;
				sum += bit * bit;
				n /= 10;
			}
			System.out.println(sum);
			if(list.contains(sum) )
				return false;
			list.add(sum);
			n = sum;
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HappyNumber ins = new HappyNumber();
		System.out.println(ins.isHappy(1000));

	}

}
