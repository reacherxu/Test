package org.xzt.hiho;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int N = in.nextInt();
    	int k = in.nextInt();
    	
    	if(k > N || k <= 0 || N < 0) {
    		System.out.println(-1);
    		return ;
    	}
    	
    	int array[] = new int[N];
    	for (int i = 0; i < N; i++) {
			array[i] = in.nextInt();
		}
    	
    	quickSort(array,0,N-1,k);
    }

	private static void quickSort(int[] a, int l, int r, int k) {
		int tmp = a[l];
		int i=l,j=r;
		while(i < j) {
			while( i<j && a[j] > tmp )
				j--;
			a[i] = a[j];
			
			while( i<j && a[i] < tmp)
				i++;
			a[j] = a[i];
		}
		a[i] = tmp;
		
		if( k == i+1 )
			System.out.println(a[i]);
		else if( k > i+1) {
			quickSort(a,i+1,r,k);
		} else {
			quickSort(a,l,i-1,k);
		}
			
	}

}