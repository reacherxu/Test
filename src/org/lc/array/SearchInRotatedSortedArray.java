package org.lc.array;
/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. 
If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array
 * @author Reacher
 *
 */
public class SearchInRotatedSortedArray {
	//关键点确定有序部分  在有序部分进行查找
	public static int search(int[] A, int target) {
		if( A.length == 0)
			return -1;
		
		int start = 0, end = A.length - 1, mid = 0;
		while(start <= end) {
			mid = (start + end) / 2;
			if( target == A[mid])
				return mid;
			if( A[mid] < A[end] ) { //right sorted
				if( target > A[mid] && target <= A[end]) 
					start = mid + 1;
				else 
					end = mid - 1;
			} else { //left sorted
				if( target >= A[start] && target < A[mid]) 
					end = mid - 1;
				else 
					start = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int a[] = {4,5,6,7,0,1,2};
		System.out.println(search(a,6));
	}
}
