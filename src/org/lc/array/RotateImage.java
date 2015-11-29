package org.lc.array;

import org.lc.util.Util;

/**
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
 * @author Reacher
 *
 */
public class RotateImage {
	//第一行到最后一列
	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		int [][]copy = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copy[i][j] = matrix[i][j];
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[j][n-1-i] = copy[i][j];
			}
		}
		Util.print(matrix);
	}
	
	//发现转置的关系
	public static void rotateII(int[][] matrix) {
		int n = matrix.length;
		//transpose
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
		
		for (int i = 0; i < n; i++) {
			int start = 0,end = n-1;
			while( start < end) {
				int tmp = matrix[i][start];
				matrix[i][start] = matrix[i][end];
				matrix[i][end] = tmp;
				
				start ++;
				end --;
			}
		}
		Util.print(matrix);
	}

	public static void main(String[] args) {
		int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		Util.print(matrix);
		rotateII(matrix);
	}
}
