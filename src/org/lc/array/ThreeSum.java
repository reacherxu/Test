package org.lc.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S 
 * such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
 * @author Reacher
 *
 */
public class ThreeSum {
	public static List<List<Integer>> threeSumI(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		//special case 1
		if(num.length < 3)
			return result;

		Arrays.sort(num);
		List<Integer> array = new ArrayList<Integer>();
		for(int i=0;i<num.length;i++) {
			array.add(num[i]);
		}

		//special case 2 000
		if( num[0] > 0 || num[num.length-1] < 0)
			return result;

		List<Integer> iUsed = new ArrayList<Integer>();
		for(int i=0;i<num.length-2 && num[i]<=0;i++) { //may duplicate
			if(iUsed.contains(num[i])) 
				continue;
			else {
				iUsed.add(num[i]);

				List<Integer> jUsed = new ArrayList<Integer>();
				for(int j=i+1;j<num.length-1;j++) {
					if( jUsed.contains(num[j]) ) {
						continue;
					} else {
						jUsed.add(num[j]);
						//note remove num[i,j]
						//special case 3
						if(0-num[i]-num[j] >=0
								&& 0-num[i]-num[j] >= num[j]
										&& array.contains(0-num[i]-num[j]) 
										&& array.lastIndexOf(0-num[i]-num[j])!=i 
										&& array.lastIndexOf(0-num[i]-num[j])!=j) {
							List<Integer> tmp = new ArrayList<Integer>();
							tmp.add(num[i]);
							tmp.add(num[j]);
							tmp.add(0-num[i]-num[j]);
							result.add(tmp);
						}
					}
				}
			}
		}
		return result;
	}

	//use two pointers
	public static List<List<Integer>> threeSumII(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		//special cases 
		if(num.length < 3)
			return result;
		Arrays.sort(num);
		if( num[0] > 0 || num[num.length-1] < 0)
			return result;

		//保证两个数不同就能保证第三个数也不同
		List<Integer> hasUsed = new ArrayList<Integer>();

		for(int i=0;i<num.length-2;i++) {
			List<Integer> startHasUsed = new ArrayList<Integer>();
			if(!hasUsed.contains(num[i])) {
				hasUsed.add(num[i]);

				int start = i+1,end = num.length-1;
				while( start < end) {
					int sum = num[start] + num[end];
					if( sum < 0-num[i]) {
						start ++;
					} else if( sum > 0-num[i]) {
						end --;
					} else {
						if( !startHasUsed.contains(num[start]) ) {
							startHasUsed.add(num[start]);

							List<Integer> tmpList = new ArrayList<Integer>();
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

		return result;
	}

	//use hashmap  编译器不支持hashtable了
	public static List<List<Integer>> threeSumIII(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		//special cases 
		if(num.length < 3)
			return result;
		Arrays.sort(num);
		if( num[0] > 0 || num[num.length-1] < 0)
			return result;

		//保证两个数不同就能保证第三个数也不同
		List<Integer> iHasUsed = new ArrayList<Integer>();
		for(int i=0;i<num.length-2;i++) {
			if(!iHasUsed.contains(num[i])) {
				iHasUsed.add(num[i]);

				//hashmap仅用于查找  因为查找时间是常数时间  但是不能保证不重复
				HashMap<Integer,Integer> table = new HashMap<Integer,Integer>();
				List<Integer> jHasUsed = new ArrayList<Integer>();
				int target = 0-num[i];
				for(int j=i+1;j<num.length;j++) {  
					if(table.containsValue(target-num[j])) {
						if( !jHasUsed.contains(target-num[j])) {
							jHasUsed.add(target-num[j]);
							
							List<Integer> tmpList = new ArrayList<Integer>();
							tmpList.add(num[i]);
							tmpList.add(target-num[j]);
							tmpList.add(num[j]);
							result.add(tmpList);
						}
					} else {
						table.put(j,num[j]);
					}
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int num[] = {0,0,0,0};
		System.out.println("threeSumI:"+threeSumI(num));
		System.out.println("threeSumII:"+threeSumII(num));
		System.out.println("threeSumIII:"+threeSumIII(num));
	}
}
