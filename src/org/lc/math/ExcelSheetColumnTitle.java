package org.lc.math;
/**
 * Given a positive integer, 
 * return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    25 -> Y
    26 -> Z
    27 -> AA
    28 -> AB 
 * @author Reacher
 *
 */
public class ExcelSheetColumnTitle {
	public static String convertToTitle(int n) {
		if( n<=0 || n>Integer.MAX_VALUE)
			return null;
		
		String res = "";
		
		int c = Integer.MAX_VALUE;
		while( n > 0 ) { 
			c = (n-1) % 26;
			res += String.valueOf( (char)('A'+c) );
			n = (n-1) / 26;
		}
		
		return reverse(res);

	}
	private static String reverse(String s) {
		String res = "";
		for(int i=0;i<s.length();i++)
			res += s.charAt(s.length()-1-i);
		return res;
		
	}
	public static void main(String[] args) {
		System.out.println(convertToTitle(52));
	}
}
