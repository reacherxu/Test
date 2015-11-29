package org.lc.math;

public class PalindromeNumber {
	public static boolean isPalindrome(int x) {
		boolean flag = false;
		if(x < 0)
			return flag;
		else if( x < 10)
			return true;
		else {
			int div = 1;
			int xDiv = x;
			while( xDiv >= 10) {  //注意等号
				xDiv /= 10;
				div *= 10;
			}
			
			while( x >= 10) {
				int left = x / div;
				int right = x % 10;
				if(left != right) {
					break;
				} else {
					x = (x - left * div - right) / 10;  //首先减法之后要除以10
					div /= 100;
					if((div==1 && x<10) || x==0 ) { //0 is the special case
						flag = true;
					}
				}
			}
		}
		
		return flag;

	}
	public static void main(String[] args) {
		System.out.println(isPalindrome(11));
	}
}
