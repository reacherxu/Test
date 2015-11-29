package org.lc.array;
/**
 * Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
 * @author Reacher
 *
 */
public class SearchInRotatedSortedArrayII {
	//有重复元素 中间和两边的元素可能相等
	public static int search(int[] A, int target) {
		if( A.length == 0)
			return -1;
		
		int start = 0, end = A.length - 1, mid = 0;
		while(start <= end) {
			mid = (start + end) / 2;
			if( target == A[mid])
				return mid;
			if( A[start] == A[mid] || A[end] == A[mid]) { // cannot determine if it's sorted
				if(A[start] == A[mid]) 
					start ++;
				if(A[end] == A[mid])
					end --;
				continue;
			} 
			if( A[mid] < A[end]) { //right sort
				if( target > A[mid] && target <= A[end])
					start = mid + 1;
				else
					end = mid - 1;
			} else {
				if(target >= A[start] && target < A[mid])
					end = mid - 1;
				else
					start = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int a[] = {3,3,3,3,1,2,3};
		System.out.println(search(a,2));
	}
}
