package org.lc.array;

import java.util.ArrayList;
import java.util.List;

import org.lc.util.Util;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5]
 * @author Reacher
 *
 */
public class SpiralMatrix {
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		List<Integer> rowList = new ArrayList<Integer>();
		List<Integer> colList = new ArrayList<Integer>();
		int row = matrix.length;
		int col = matrix[0].length;
		
		for (int i = 0; i < row; i++) {
			rowList.add(i);
		}
		for (int i = 0; i < col; i++) {
			colList.add(i);
		}
		
		int i = 0,j = 0;
		while ( !(rowList.size()==0 && colList.size()==0) ) {
			if( i == rowList.get(0) && j < colList.get(colList.size()-1) ) {
				res.add(matrix[i][j]);
				j++;
			}
			
			if( j == colList.get(colList.size()-1)  && i < rowList.get(rowList.size()-1)) {
				if( j == colList.get(colList.size()-1)  && i == rowList.get(0))
					rowList.remove(i);
				res.add(matrix[i][j]);
				i++;
			}
			
			if( i == rowList.get(rowList.size()-1) && j > colList.get(0)) {
				if( i == rowList.get(rowList.size()-1) && j == colList.get(colList.size()-1))
					colList.remove(j);
				res.add(matrix[i][j]);
				j--;
			}
			
			if( j == colList.get(0)  && i > rowList.get(0) ) {
				if( j == colList.get(0)  && i == rowList.get(rowList.size()-1) )
					rowList.remove(i);
				res.add(matrix[i][j]);
				i--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		Util.print(matrix);
		System.out.println(spiralOrder(matrix));
	}
}
