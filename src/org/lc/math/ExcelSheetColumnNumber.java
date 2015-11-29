package org.lc.math;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
 * @author Reacher
 *
 */
public class ExcelSheetColumnNumber {
	public static int titleToNumber(String s) {
		if(s.length() == 0 || s == null)
			return 0;
		
		s = s.toUpperCase();
		int res = 0;
		
		for(int i=0;i<=s.length()-1;i++) {
			res += (s.charAt(i)-'A'+1) * Math.pow(26, s.length()-1-i);
		}
		return res;

	}
	
	public static void main(String[] args) {
		System.out.println(titleToNumber("AB"));
	}
}
