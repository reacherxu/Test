package org.lc.math;

import java.util.ArrayList;
import java.util.List;

/**
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 * @author Reacher
 *
 */
public class AddBinary {
	public static String addBinaryI(String a, String b) { //超出int 表示范围的问题
		
		if(a.length() == 0|| a==null ||b.length() == 0|| b==null )
			return null;
		
		int addA = binToDeci(a);
		int addB = binToDeci(b);
		int addC = addA + addB;
		return deciToBin(addC);
	}
	
	public static String addBinary(String a, String b) { 
//		int maxLen = a.length() > b.length() ? a.length() : b.length();
		
		if(a.length() == 0|| a==null ||b.length() == 0|| b==null )
			return null;
		
		String res = "";
		int carry = 0;
		int aBit = 0 ,bBit = 0;
		while( !a.equals("") || !b.equals("")) {
			//the last bit
			if( !a.equals("") && !b.equals("") ) {
				aBit = Integer.parseInt(String.valueOf(a.charAt(a.length()-1)));
				bBit = Integer.parseInt(String.valueOf(b.charAt(b.length()-1)));
			} else if (!a.equals("") && b.equals("")) {
				aBit = Integer.parseInt(String.valueOf(a.charAt(a.length()-1)));
				bBit = 0;
			} else {
				aBit = 0;
				bBit = Integer.parseInt(String.valueOf(b.charAt(b.length()-1)));
			}

			switch (aBit + bBit + carry) {
			case 0:
				carry = 0;
				res += "0";
				break;
			case 1:
				carry = 0;
				res += "1";
				break;
			case 2:
				carry = 1;
				res += "0";
				break;
			case 3:
				carry = 1;
				res += "1";
				break;
			}
			
			//remove the last bit
			if( !a.equals("") && !b.equals("") ) {
				a = a.substring(0, a.length()-1);
				b = b.substring(0, b.length()-1);
			} else if (!a.equals("") && b.equals("")) {
				a = a.substring(0, a.length()-1);
				b = "";
			} else {
				a = "";
				b = b.substring(0, b.length()-1);
			}
			
		}
		if(carry == 1)
			res += 1;
		return reverse(res);
	}
	
	private static String reverse(String s) {
		String res = "";
		for(int i=0;i<s.length();i++)
			res += s.charAt(s.length()-1-i);
		return res;
		
	}
	private static String deciToBin(int add) {
		List<String> arr = new ArrayList<String>();
		if(add == 0) //special case 1
			return "0";
		while( add != 0) {
			int bit = add % 2;
			arr.add(bit+"");
			add = add / 2;
		}
		
		String res = "";
		for(int i=arr.size()-1;i>=0;i--) {
			res += arr.get(i);
		}
		return res;
	}

	private static int binToDeci(String a) {
		int res = 0;
		for(int i=0;i<a.length();i++) {
			res += Integer.parseInt(String.valueOf(a.charAt(i))) * Math.pow(2, a.length()-1-i) ;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(addBinary("111","1"));
	}
}
