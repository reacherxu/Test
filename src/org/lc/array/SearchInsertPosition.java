package org.lc.array;
/**
 * Given a sorted array and a target value, 
 * return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
 * @author Reacher
 *
 */
public class SearchInsertPosition {
	//TODO  implement binary search
	public static int searchInsert(int[] A, int target) {
		if(A.length == 0)
			return 0;
		
		int index = 0;
		for(int i=0;i<A.length;i++) {
			if( A[i] == target ) {
				index = i;
				break;
			} 
			if( A[i] > target ) {
				if( i == 0) {
					index = 0;
					break;
				} else {
					index = i;
					break;
				}
			}
			if( i == A.length-1 )
				index = A.length;
		}
		return index;
	}
	
	//binary search
	//two base cases  1.begin=end=mid  2.begin=end-1=mid
	public static int searchInsertI(int[] A, int target) {
		if(A.length == 0)
			return 0;
		
		int begin = 0, end = A.length-1;
		while( begin <= end ) {
			
			int mid = (begin + end) / 2;
			if( A[mid] == target) {
				return mid;
			} else if( A[mid] < target ) {
				begin = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return begin;
	}
	
	/**Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0*/
	public static void main(String[] args) {
		int a[] = {1,3,5,6};
		System.out.println(searchInsertI(a,0));
	}
}
