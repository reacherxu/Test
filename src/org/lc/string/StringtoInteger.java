package org.lc.string;

/**
 * The function first discards as many whitespace characters as necessary 
 * until the first non-whitespace character is found. Then, 
 * starting from this character, takes an optional initial plus or minus sign 
 * followed by as many numerical digits as possible,
 *  and interprets them as a numerical value.
The string can contain additional characters after those that form the integral number,
 which are ignored and have no effect on the behavior of this function.
If the first sequence of non-whitespace characters in str is not a valid integral number,
 or if no such sequence exists because either str is empty or it contains only whitespace characters, 
 no conversion is performed.
If no valid conversion could be performed, a zero value is returned.
 If the correct value is out of the range of representable values, 
 INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * @author Reacher
 *
 */
public class StringtoInteger {
	public static int atoi(String str) {
		str = str.trim();
		if(str.length() == 0)
			return 0;
		boolean sign = false;
		long result = 0;
		
		for(int i=0;i<str.length();i++) {
			if( i==0  ) {
				if( str.charAt(i) == '-') {
					sign = true;
				} else if(str.charAt(i) == '+') {
					sign = false;
				}else {
					if( '0' <= str.charAt(i) && str.charAt(i) <='9') 
						result += str.charAt(i)-'0';
					else {
						return 0;
					}
				}
			} else {
				if( '0' <= str.charAt(i) && str.charAt(i) <='9') {
					result = result*10 + str.charAt(i)-'0';
					if( sign && (-1)*result < Integer.MIN_VALUE )
						return Integer.MIN_VALUE;
					if( sign==false && result > Integer.MAX_VALUE)
						return Integer.MAX_VALUE;
				}
				else 
					break;
			}
		}
			
		if( sign && result==0)
			return 0;
		if(sign) {
			return (int) ((-1)*result);
		}
		else
			return (int) result;
	}
	public static void main(String[] args) {
		System.out.println(atoi("+2147483648"));
	}
}
