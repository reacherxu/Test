package org.lc.bit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?
 * @author Reacher
 *
 */
public class SingleNumber {
	public static int singleNumber(int[] A) {
		Arrays.sort(A);
		int res = 0;
		for (int i = 0; i < A.length; i+=2) {
			if(i == A.length - 1 ) {
				res = A[i];
			} else {
				if( A[i] != A[i+1]) {
					res = A[i];
					break;
				}
			}
		}
		return res;
	}
	public static int singleNumberII(int[] A) {
		HashMap<Integer,Integer> table = new HashMap<Integer,Integer>();
		for (int i = 0; i < A.length; i++) {
			if( !table.containsKey(A[i])) {
				table.put(A[i], 1);
			} else {
				table.remove(A[i]);
			}
		}
		Iterator<Integer> it = table.keySet().iterator();
		return it.next();
	}
	
	public static int singleNumberIII(int[] A) {
		int res = A[0];
		for (int i = 1; i < A.length; i++) {
			res  ^= A[i];
		}
		return res;
	}
	public static void main(String[] args) {
		int a[] = {2,7,9,9,7};
		System.out.println(singleNumberIII(a));
	}
}
