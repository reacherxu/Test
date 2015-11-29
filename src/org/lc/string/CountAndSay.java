package org.lc.string;
/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 * @author Reacher
 *
 */
public class CountAndSay {
	public static String countAndSay(int n) {
		if( n <= 0)
			return null;
		
		String res = "1";
		for(int i=0;i<n-1;i++) {
			res = say(res);
		}
		return res;   
	}
	private static String say(String s) {
		if( s.length() == 1)
			return "11";
		else {
			String res = "";
			int count = 1;
			char current = s.charAt(0);
			for(int i=1;i<s.length();i++) {
				if( s.charAt(i) == current ) {
					count ++;
				}
				else {
					res += count + "" + current;
					current = s.charAt(i);
					count = 1;
				}
				
				//this is the most important
				if( i == s.length()-1)
					res += count + "" + current;
			}
			return res;
		}
	}
	public static void main(String[] args) {
		System.out.println(countAndSay(5));
	}
}
