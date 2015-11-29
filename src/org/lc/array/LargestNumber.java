package org.lc.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 * @author Reacher
 *
 */
public class LargestNumber {
	
	class StringComparator implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			return (o2 + o1).compareTo(o1 + o2);
		}
		
	}
	public String largestNumber(int[] num) {
		String res = "";
		int len = num.length;
		String s[] = new String[len];
		for (int i = 0; i < len; i++) {
			s[i] = String.valueOf(num[i]);
		}
		Arrays.sort(s,new StringComparator());
		for (int i = 0; i < len; i++) {
			res += s[i];
		}
		if("".equals(res.replace("0", "")))
			res = "0";
		return res;
	}
	
	public static void main(String[] args) {
		LargestNumber ins = new LargestNumber();
		int a[] = {0, 0};
		System.out.println(ins.largestNumber(a));
	}
}
