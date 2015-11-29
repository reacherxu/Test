package org.lc.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S
 *  such that a + b + c + d = target? Find all unique quadruplets in the array
 *   which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
 * @author Reacher
 *
 */
public class FourSum {
	//use two pointers
	public static List<List<Integer>> fourSumI(int[] num, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		//special cases 
		if(num.length < 4)
			return result;
		Arrays.sort(num);

		List<Integer> kHasUsed = new ArrayList<Integer>();
		for(int k=0;k<num.length-3;k++) { //k-th 
			if(!kHasUsed.contains(num[k])) {
				kHasUsed.add(num[k]);

				List<Integer> iHasUsed = new ArrayList<Integer>();
				for(int i=k+1;i<num.length-2;i++) {//i-th 
					List<Integer> startHasUsed = new ArrayList<Integer>();
					if(!iHasUsed.contains(num[i])) {
						iHasUsed.add(num[i]);

						int start = i+1,end = num.length-1;
						while( start < end) {
							int sum = num[start] + num[end];
							if( sum < target-num[i]-num[k]) {
								start ++;
							} else if( sum > target-num[i]-num[k]) {
								end --;
							} else {
								if( !startHasUsed.contains(num[start]) ) {
									startHasUsed.add(num[start]);

									List<Integer> tmpList = new ArrayList<Integer>();
									tmpList.add(num[k]);
									tmpList.add(num[i]);
									tmpList.add(num[start]);
									tmpList.add(num[end]);
									result.add(tmpList);

									start ++;
									end --;
								} else {
									start++;
								}
							}
						}
					}
				}
			}
		}

		return result;
	}

	//use hashmap  
	public static List<List<Integer>> fourSumII(int[] num, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		//special cases 
		if(num.length < 4)
			return result;
		Arrays.sort(num);

		//保证3个数不同就能保证第4个数也不同
		List<Integer> kHasUsed = new ArrayList<Integer>();
		for(int k=0;k<num.length-3;k++) { //k-th 
			if(!kHasUsed.contains(num[k])) {
				kHasUsed.add(num[k]);
				List<Integer> iHasUsed = new ArrayList<Integer>();
				for(int i=k+1;i<num.length-2;i++) {
					if(!iHasUsed.contains(num[i])) {
						iHasUsed.add(num[i]);

						//hashmap仅用于查找  因为查找时间是常数时间  但是不能保证不重复
						HashMap<Integer,Integer> table = new HashMap<Integer,Integer>();
						List<Integer> jHasUsed = new ArrayList<Integer>();
						int sum = target-num[i]-num[k];
						for(int j=i+1;j<num.length;j++) {  
							if(table.containsValue(sum-num[j])) {
								if( !jHasUsed.contains(sum-num[j])) {
									jHasUsed.add(sum-num[j]);

									List<Integer> tmpList = new ArrayList<Integer>();
									tmpList.add(num[k]);
									tmpList.add(num[i]);
									tmpList.add(sum-num[j]);
									tmpList.add(num[j]);
									result.add(tmpList);
								}
							} else {
								table.put(j,num[j]);
							}
						}
					}
				}
			}
		}
		

		return result;
	}
	public static void main(String[] args) {
		int num[] = {-1,-5,-5,-3,2,5,0,4};
		int target = -7;
		System.out.println("fourSumI:"+fourSumI(num,target));
		System.out.println("fourSumII:"+fourSumII(num,target));
	}
}
