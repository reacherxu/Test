package org.lc.array;
/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
 * @author Reacher
 *
 */
public class FindMinimumInRotatedSortedArray {
	public static int findMin(int[] num) {
		if( num.length == 0 )
			return 0;
		
		int min = Integer.MAX_VALUE;
		
		int start = 0,end = num.length-1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if( num[start] <= num[mid]) { //left sorted
				if( num[start] < min)
					min = num[start];
				start = mid + 1;
			} 
			if( num[mid] <= num[end]) { //right sorted
				if( num[mid] < min)
					min = num[mid];
				end = mid - 1;
			}
		}
		return min;
	}
	public static void main(String[] args) {
		int a[] = {4};
		System.out.println(findMin(a));
	}
}
