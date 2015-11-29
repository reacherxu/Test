package org.lc.dp;


/**
 * Given two words word1 and word2, 
 * find the minimum number of steps required to convert word1 to word2. 
 * (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
 * @author Reacher
 *
 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		if(word1 == null || word2 == null || (m==0 && n==0) )
			return 0;
		if(m==0 && n!=0)
			return n;
		if(m!=0 && n==0)
			return m;
		
		int dp[][] = new int[m+1][n+1];
		//从0个字符开始
		for (int i = 0; i <= n; i++) {
			dp[0][i] = i;
		}
		for (int j = 0; j < m; j++) {
			dp[j][0] =j;
		}
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if( word1.charAt(i-1) == word2.charAt(j-1) ) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		EditDistance ins = new EditDistance();
		System.out.println(ins.minDistance("ea", "eat"));
	}
}
