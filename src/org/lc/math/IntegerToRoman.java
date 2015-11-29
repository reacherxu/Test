package org.lc.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer, convert it to a roman numeral.
		case 'I': return 1;   
		case 'V': return 5;  
		case 'X': return 10;  
		case 'L': return 50;  
		case 'C': return 100;  
		case 'D': return 500;  
		case 'M': return 1000; 
Input is guaranteed to be within the range from 1 to 3999.
 * @author Reacher
 *
 */
public class IntegerToRoman {
	public static String intToRoman(int num) {
		String res = "";
		List<String> roman = new ArrayList<String>();
		
		int pos = 0;
		while( num != 0) {
			pos ++;
			int digit = num % 10;
			num = num / 10;
			
			switch (pos) {
			case 1:
				roman.add(romanChar(digit,"I","V","X"));
				break;
			case 2:
				roman.add(romanChar(digit,"X","L","C"));
				break;
			case 3:
				roman.add(romanChar(digit,"C","D","M"));
				break;
			case 4:
				if(digit == 0)
					roman.add("");
				else {
					String thousand = "";
					for(int i=0;i<digit;i++)
						thousand += "M";
					roman.add(thousand);
				}
				break;

			}
		}
		
		for(int i=roman.size()-1;i>=0;i--) 
			res += roman.get(i);
		return res;

	}
	private static String romanChar(int digit, String one, String five,
			String ten) {
		if(digit == 0)
			return "";
		
		String res = "";
		if(digit <= 3) {
			String temp = "";
			for(int i=0;i<digit;i++)
				temp += one;
			res = temp;
		} else if(digit == 4) {
			res += one+five;
		} else if(digit >= 5 && digit <=8) {
			String temp = five;
			for(int i=0;i<digit-5;i++)
				temp += one;
			res = temp;
		} else if( digit == 9) {
			res += one+ten;
		} else {
			res += ten;
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(intToRoman(999));
	}
}
