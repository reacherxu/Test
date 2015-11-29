package org.lc.array;
/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 *  This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true
 * @author Reacher
 *
 */
public class Search2DMatrix {
	public static boolean searchMatrix(int[][] matrix, int target) {
		if( matrix.length == 0)
			return false;

		int start = 0,end = matrix.length-1,mid = 0,row = 0;
		while( start <= end ) { //ensure the row
			if(start == end ) {
				row = start;
				break;
			}
			mid = (start + end) / 2;
			if(target >= matrix[mid][0] && target <= matrix[mid][matrix[0].length-1]) {
				row = mid;
				break;
			}


			if( target == matrix[mid][0] ) //特别注意：这里没有考虑中间一行
				return true;
			if( target < matrix[mid][0]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		start = 0;
		end = matrix[0].length-1;
		while( start <= end) {
			mid = (start + end) / 2;
			if( target == matrix[row][mid])
				return true;
			if( target < matrix[row][mid])
				end = mid - 1;
			else 
				start = mid + 1;
		}
		return false;
	}
	public static void main(String[] args) {
		int matrix[][] = {
				{1,   3,  5,  7},
				{10, 11, 16, 20},
				{23, 30, 34, 50}
		};
		System.out.println(searchMatrix(matrix,11));
	}
}
