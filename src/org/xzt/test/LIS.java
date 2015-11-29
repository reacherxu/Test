package org.xzt.test;

import java.util.Arrays;

public class LIS {
	public static void main(String[] args) {
		int num[] = {2,1,5,3,6,4,8,9,7};
		System.out.println( lis(num));
	}

	private static int lis(int[] num) {
		int res[] = new int[num.length];
		int len = num.length;
		for (int i = 0; i < len; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if(num[j] <= num[i] && res[j] >= max)
					max = res[j];
			}
			res[i] = max+1;
		}
		Arrays.sort(res);
		return res[len - 1];
	}
}
