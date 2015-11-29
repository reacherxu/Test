package org.lc.array;


/*  Given an array and a value, remove all instances of that value in place and
 *  return the new length.
The order of elements can be changed.
 It doesn't matter what you leave beyond the new length.*/

public class RemoveElement {
	public static int removeElement(int[] A, int elem) {
		if(A==null || A.length==0)
			return 0;
		
		int count = 0;
		for(int i=0;i<A.length;i++) {
			if( A[i] == elem) {
				count++;
			} else {
				A[i-count] = A[i];
			}
		}
		
		return A.length-count;
	}
	
	public static void main(String[] args) {
		int A[] = {13,2,4,6,2,3};
		removeElement(A,2);
	}
}
