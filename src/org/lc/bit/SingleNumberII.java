package org.lc.bit;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given an array of integers, every element appears three times except for one. 
 * Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * @author Reacher
 *
 */
public class SingleNumberII {
	public static int singleNumber(int[] A) {
		int res = 0;
		HashMap<Integer,Integer> table = new HashMap<Integer,Integer>();
		for (int i = 0; i < A.length; i++) {
			if( !table.containsKey(A[i])) {
				table.put(A[i], 1);
			} else {
				int count = table.get(A[i]) + 1;
				table.put(A[i], count);
			}
		}
		Iterator<Entry<Integer, Integer>> it = table.entrySet().iterator();
		while( it.hasNext() ) {
			Map.Entry<Integer, Integer> entry = (Entry<Integer, Integer>) it.next();
			if(entry.getValue() == 1) {
				res = entry.getKey();
				break;
			}
		}
		return res;
	}
	
	public static int singleNumberII(int[] A) {
		int res = 0;
		int count[] = new int[Integer.SIZE];
		for (int i = 0; i < Integer.SIZE; i++) {
			for (int j = 0; j < A.length; j++) {
				count[i] += (A[j] >> i) & 1;
			}
			res |= (count[i] % 3) << i;
		}
		return res;
	}
	public static void main(String[] args) {
		int a[] = {2,4,7,9,7,9,9,7,2,2};
		System.out.println(singleNumberII(a));
	}
	
}
