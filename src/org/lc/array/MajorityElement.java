package org.lc.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
	You may assume that the array is non-empty and the majority element always exist in the array.
 * @author Reacher
 *
 */
public class MajorityElement {
	public static int majorityElement(int[] num) {
		int threshold = num.length/2;
		int res = 0;
		
		if(num.length == 1)
			return num[0];
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int n : num) {
			if( !map.containsKey(n) ) {
				map.put(n, new Integer(1));
			} else {
				int count = map.get(n) + 1;
				if( count > threshold ) {
					res = n;
					break;
				}
				else 
					map.put(n, count);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		
	}
}
