package org.lc.math;
/**
 * Given a roman numeral, convert it to an integer.
		
Input is guaranteed to be within the range from 1 to 3999.
 * @author Reacher
 *
 */
public class RomanToInteger {
	public static int romanToInt(String s) {
		
		s = s.toUpperCase();

		if( s.length() == 0)
			return 0;
		if( s.length() == 1)
			return getRomanValue(s.charAt(0));
		
		int res = 0,diff = 0;
		int i = 0,cur = 0,next = 0;
		while( i < s.length()-1 ) { 
			cur = getRomanValue(s.charAt(i));
			next = getRomanValue(s.charAt(i+1));
			if(cur < next ) {
				diff += 2 * cur;
			}
			
			res += cur ;
			i++;
		}
		res += next;
		
		return res-diff;
	}

	public static int getRomanValue(char c) {  
		switch(c) {  
		case 'I': return 1;   
		case 'V': return 5;  
		case 'X': return 10;  
		case 'L': return 50;  
		case 'C': return 100;  
		case 'D': return 500;  
		case 'M': return 1000;  
		default: return 0;  
		}  
	}  
	public static void main(String[] args) {
		System.out.println(romanToInt("CMXCIX"));
	}
}
