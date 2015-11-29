package org.lc.array;

import org.lc.util.Util;


/**
 * Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
 * @author Reacher
 *
 */
public class RemoveDuplicatesfromSortedArray {
	public static int removeDuplicates(int[] A) {
		if( A.length <= 1)
			return A.length;
			
		int i,recurrence=0;  //recurrence 是统计重复的总次数
		for( i=1;i<A.length;i++ ) {
			if( A[i] == A[i-1]) {
				recurrence ++;
			} else {
				A[i-recurrence] = A[i];
			}
		}
		Util.print(A);
		return A.length-recurrence;

	}
	public static void main(String[] args) {
		int A[] = {1,1,1,2,2,3};
		Util.print(A);
		System.out.println(removeDuplicates(A));
		
	}
}
