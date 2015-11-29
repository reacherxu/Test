package org.lc.array;

import org.lc.util.Util;

/**
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, 
then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space
 * @author Reacher
 *
 */
public class SortColors {
	public void sortColors(int[] A) {
		//below are cornor cases
		if(A.length <= 1)
			return;
		//form sorted list
		int left = 0,right = A.length-1;
		while( left <= A.length-1 && A[left] == 0)
			left++;
		if(left >= A.length)
			return ;
		while( right >= 0 && A[right] == 2)
			right--;
		if(right <= 0)
			return;
		int mid = left; //注意   不能两个都未知
		
		while (mid <= right) {
			if( A[mid] == 0) {
				swap(A,left++,mid++);
			}
			else if( A[mid] == 2) {
				swap(A,mid,right--);
			}
			else
				mid++;
		}
	}
	
	private void swap(int[] a, int left, int mid) {
		int tmp = a[left];
		a[left] = a[mid];
		a[mid] = tmp;
	}

	public static void main(String[] args) {
		SortColors ins = new SortColors();
		int A[] = {0,2,1};
		
		ins.sortColors(A);
		Util.print(A);
	}
}
