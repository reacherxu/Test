package org.lc.array;

import java.util.Arrays;

import org.lc.util.Util;

/**
 * Given two sorted integer arrays A and B, 
 * merge B into A as one sorted array.
 * @author Reacher
 *Summary: It's easy, but should be careful about corner cases, like m is 0, n is 0. 
 */
public class MergeSortedArray {
	/*You should not create a new array to merge A and B together.
	 * You should only use A and B, 
	 */
	public static void mergeNew(int A[], int m, int B[], int n) {
		int tmp[] = new int[m+n];
		int i=0,j=0,k=0;
		if(m == 0) {
			A = B;
			Util.print(A);
			return ;
		}
		if(n == 0)
			return;
		while( k < m+n ) {
			if( i==m && j<n) { //A is full
				tmp[k++] = B[j++];
			} else if( j==n && i<m) { //B is full
				tmp[k++] = A[i++];
			} else {
				if(A[i] < B[j] ) {
					tmp[k++] = A[i++];
				} else {
					tmp[k++] = B[j++];
				}
			}
		}
		A = tmp;
		Util.print(A);
	}
	
	//get accepted
	public static void merge2(int A[], int m, int B[], int n) {
		if(m == 0) {
			System.arraycopy(B,0,A,0,n);
			return;
		}
		if( n == 0)
			return;
		System.arraycopy(B,0,A,m,n);
		Arrays.sort(A);
		Util.print(A);
	}
	
	public static void merge(int A[], int m, int B[], int n) {
		if(m == 0) {
			System.arraycopy(B, 0, A, 0, n);
			return ;
		}
		if(n == 0)
			return ;
		int i=m-1,j=n-1;
		for(int k=m+n-1;k>=0;k--) {
			if(j < 0 ) {
				A[k] = A[i--];
				continue;
			} else if( i < 0 ) {
				A[k] = B[j--] ;
				continue;
			}
				
			if( A[i] > B[j]) {
				A[k] = A[i--];
			} else {
				A[k] = B[j--] ;
			}
		}
		Util.print(A);
	}
	
	public static void main(String[] args) {
		
		int A[] = new int[2];
		A[0]=2;
		int B[] = {1};
		Util.print(A);
		Util.print(B);
		merge(A,1,B,1);
		
	}
}
