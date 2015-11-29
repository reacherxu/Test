package org.lc.array;
/**
 * Given a sorted array of integers, find the starting and ending position 
 * of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 * @author Reacher
 *
 */
public class SearchForRange {
	public int[] searchRange(int[] A, int target) {
		int index[] = new int[2];
		index[0] = findLeftBorder(A,target);
		index[1] = findRightBorder(A,target);
		return index;
	}
	
	private int findRightBorder(int[] a, int target) {
		if(a.length == 0)
			return -1;
		
		int start = 0, end = a.length - 1,mid = 0;
		while( start <= end ) {
			mid = (start + end) / 2;
			if(  target == a[mid] ) 
				start = mid + 1;
			else if( target < a[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		if( end >= 0 && end <= a.length-1 && a[end] == target)
			return end;
		return -1;
	}

	private int findLeftBorder(int[] a, int target) {
		if(a.length == 0)
			return -1;
		
		int start = 0, end = a.length - 1,mid = 0;
		while( start <= end ) {
			mid = (start + end) / 2;
			if(  target == a[mid] ) 
				end = mid - 1;
			else if( target < a[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		if( start >= 0 && start <= a.length-1 && a[start] == target)
			return start;
		return -1;
	}

	public static void main(String[] args) {
		int a[] = {5, 7, 7, 8, 8, 10};
		SearchForRange instance = new SearchForRange();
		int index[] = instance.searchRange(a,8);
		System.out.println(index[0]+"\t"+index[1]);
	}
}
