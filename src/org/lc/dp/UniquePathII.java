package org.lc.dp;

import org.lc.util.Util;

/**
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.
 * @author Reacher
 *
 */
public class UniquePathII {
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int res[][] = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			if( obstacleGrid[i][0] != 1)
				res[i][0] = 1; 
			else {
				res[i][0] = 0;
				break;
			}
		}
		for (int i = 0; i < n; i++) {
			if( obstacleGrid[0][i] != 1)
				res[0][i] = 1; 
			else {
				res[0][i] = 0; 
				break;
			}
		}
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if(obstacleGrid[i][j] == 1) {
					res[i][j] = 0;
					continue;
				}
				int up = res[i-1][j];
				int left = res[i][j-1];
				res[i][j] = up + left;
			}
		}
		Util.print(res);
		return res[m-1][n-1];
	}


	public static void main(String[] args) {
		int a[][] = {
		              {0,0,0},
		              {0,1,0},
		              {0,0,0}
		            };
		uniquePathsWithObstacles(a);
	}
}
