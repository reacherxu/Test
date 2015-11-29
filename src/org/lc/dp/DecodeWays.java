package org.lc.dp;
/**
 * A message containing letters from A-Z is being encoded to numbers 
 * using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 * @author Reacher
 *
 */
public class DecodeWays {
	public int numDecodings(String s) {
		if(s == null || s.length() == 0)
			return 0;
		int len = s.length();
		int dp[] = new int[len+1];
		dp[0] = 1;
		if(s.charAt(0) == '0')
			return 0;
		else
			dp[1] = 1;
		
		//当前数字是0 肯定不行
		for (int i = 2; i <= len; i++) {
			char c = s.charAt(i-1);
			if( c != '0')
				dp[i] += dp[i-1];
			
			String sub = s.substring(i-2,i);
			if(sub.startsWith("0"))  //也不能以0开头
				continue;
			int num = Integer.parseInt(sub);
			if( num >= 1 && num <= 26)
				dp[i] += dp[i-2];
			
		}
		return dp[len];
	}
	public static void main(String[] args) {
		DecodeWays ins = new DecodeWays();
		System.out.println(ins.numDecodings("101"));
	}
}
