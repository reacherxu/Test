package org.lc.dp;


/**
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. 
In how many distinct ways can you climb to the top?
 * @author Reacher
 *
 */
public class ClimbingStairs {
	public static  int climbStairs(int n) {
		if( n== 1)
			return 1;
		else if( n == 2)
			return 2;
		else
			return climbStairs(n-1) + climbStairs(n-2);
	}
	
	public static int climbStairsII(int n) {
		int stairs[] = new int[n+1];
		stairs[0] = 1;
		stairs[1] = 1;
		for (int i = 2; i <= n; i++) {
			stairs[i] = stairs[i-1] + stairs[i-2];
		}
		return stairs[n];
	}
	
	public static int climbStairsIII(int n) {
		if( n== 1)
			return 1;
		if( n == 2)
			return 2;
		int pre = 1,p = 1,q = 0;
		for (int i = 2; i <= n; i++) {
			q = pre + p;
			pre = p;
			p = q;
		}
		return q;
	}
	public static void main(String[] args) {
		System.out.println(climbStairs(11));
		System.out.println(climbStairsII(11));
		System.out.println(climbStairsIII(11));
	}
}
