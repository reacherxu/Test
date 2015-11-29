package org.lc.array;
/**
 * Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
 * @author Reacher
 *
 */
public class FindMinimumInRotatedSortedArrayII {
	public static int findMin(int[] num) {
		if( num.length == 0 )
			return 0;
		int start = 0,end = num.length-1,mid = (start + end) / 2;
		int min = num[mid];
		
		while (start <= end) {
			mid = (start + end) / 2;
			if( num[start] == num[mid] && start != mid) {
				start ++;
				continue;
			}
			if( num[end] == num[mid] && end != mid) {
				end --;
				continue;
			}
			
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
		int a[] = {3};
		System.out.println(findMin(a));
	}
}
