package org.lc.dp;

import org.lc.util.Util;

/**
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right 
 * which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 * @author Reacher
 *
 */
public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		if(grid.length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		if(m==1 && n==1)
			return grid[0][0];
		
		int[][] step = new int[m][n];
		step[0][0] = grid[0][0];
		for (int i = 1; i < n; i++) {
			step[0][i] = step[0][i-1] + grid[0][i];
		}
		for (int i = 1; i < m; i++) {
			step[i][0] = step[i-1][0] + grid[i][0];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				step[i][j] = grid[i][j] + Math.min(step[i-1][j],step[i][j-1]);
			}
		}
		return step[m-1][n-1];
	}

	public static void main(String[] args) {
		MinimumPathSum ins = new MinimumPathSum();
		int A[][] = {
				{2,1,5},
				{6,4,7},
				{1,2,1}
				};
		Util.print(A);
		System.out.println(ins.minPathSum(A));
	}
}
