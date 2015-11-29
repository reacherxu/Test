package org.lc.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array S of n integers, find three integers in S 
 * such that the sum is closest to a given number, target.
 *  Return the sum of the three integers. 
 *  You may assume that each input would have exactly one solution.
 * @author Reacher
 *
 */
public class ThreeSumClosest {
	// Time Limit Exceeded
	public static int threeSumClosestI(int[] num, int target) {
		int len = num.length;
		List<Integer> resultList = new ArrayList<Integer>();
		for(int i=0;i<len-2;i++) {
			for(int j=i+1;j<len-1;j++) {
				for(int k=j+1;k<len;k++) {
					resultList.add(Math.abs(num[i]+num[j]+num[k]-target));
				}
			}
		}
		Collections.sort(resultList);
		System.out.println(resultList);
		
		return resultList.get(0)+target;
	}
	
	public static int threeSumClosest(int[] num, int target) {
		int n = num.length;
        Arrays.sort(num);
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int start = i + 1, end = n - 1;
            int sum = target - num[i];
            int cur = 0;
            while (start < end) {
                cur = num[start] + num[end];
                if (Math.abs(cur + num[i] - target) < min) {
                    min = Math.abs(cur + num[i] - target);
                    result = cur + num[i];
                }
                if (cur < sum)
                    start++;
                else if (cur > sum)
                    end--;
                else {
                    start++;
                    end--;
                }
            }
        }
        return result;
	}
	public static void main(String[] args) {
		int nums[] = {1,2,4,8,16,32,64,128};
		System.out.println(threeSumClosest(nums,82));
	}
}
