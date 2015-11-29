package org.lc.array;

import org.lc.util.Util;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. 
 * Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 * @author Reacher
 *
 */
public class SetMatrixZeroes {
	//注意  这道题不能一边扫一遍置0
	public void setZeroes(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int rows[] = new int[row];
		int cols[] = new int[col];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if( matrix[i][j] == 0) {
					rows[i] = 1;
					cols[j] = 1;
				}
			}
		}
		
		for (int i = 0; i < row; i++) {
			if(rows[i] == 1)
				zeros(matrix[i]);
		}
		for (int j = 0; j < col; j++) {
			if(cols[j] == 1)
				for (int i = 0; i < row; i++) {
					matrix[i][j] = 0;
				}
		}
		Util.print(matrix);
	}
	
	private void zeros(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = 0;
		}
	}

	
	//巧妙利用自身空间
	public void setZeroesII(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		
		boolean rowFlag = false,colFlag = false;
		//record the 0-th row and 0-th col
		for (int i = 0; i < col; i++) {
			if( matrix[0][i] == 0) {
				rowFlag = true;
			}
		}
		for (int i = 0; i < row; i++) {
			if( matrix[i][0] == 0) {
				colFlag = true;
			}
		}
		
		//use the the 0-th row and 0-th col to record the entire matrix
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if( matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		Util.print(matrix);
		for (int i = 1; i < row; i++) {
			if(matrix[i][0] == 0)
				zeros(matrix[i]);
		}
		for (int j = 1; j < col; j++) {
			if(matrix[0][j] == 0)
				for (int i = 0; i < row; i++) {
					matrix[i][j] = 0;
				}
		}
		if(rowFlag == true) {
			zeros(matrix[0]);
		}
		if(colFlag == true) {
			for (int j = 0; j < row; j++) {
				matrix[j][0] = 0;
			}
		}
		
		Util.print(matrix);
	}
	public static void main(String[] args) {
		int matrix[][] = {{1,1,1},{0,1,2}};
		Util.print(matrix);
		SetMatrixZeroes ins = new SetMatrixZeroes();
		ins.setZeroesII(matrix);

	}
}
