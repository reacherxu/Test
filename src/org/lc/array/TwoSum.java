package org.lc.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*Given an array of integers, find two numbers such that they add up to 
 * a specific target number.The function twoSum should return 
 * indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. Please note that 
 * your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.*/
public class TwoSum {
	public static int[] twoSum1(int[] numbers, int target) {
		int []indices = new int[2];
		/*Time Limit Exceeded  系统不能容忍O(n*n)
		 * for(int index1=0;index1<numbers.length;index1++) {
			for(int index2=index1+1;index2<numbers.length;index2++) {
				if(numbers[index1] + numbers[index2] == target) {
					indices[0] = index1 + 1;
					indices[1] = index2 + 1;
					break;
				}
			}
		}*/
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<numbers.length;i++) {
			map.put(i,numbers[i]);  //保证key值不重复
		}
		Arrays.sort(numbers);
		
		int pre=0,p=1;
		while( numbers[pre] + numbers[p] != target) {
			if( numbers[pre] + numbers[p] < target ) { //保证pre为小的一方
				pre = p;
				p = p + 1;
			} 
			if( numbers[pre] + numbers[p] > target ) {
				pre = pre - 1;
			} 
		}
		boolean flag = true;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if( entry.getValue() == numbers[pre] && flag) {
				indices[0] = entry.getKey() + 1;
				flag = false;
			}
			if(entry.getValue() == numbers[p] && flag == false)
				indices[1] = entry.getKey() + 1;
		}
		
		return indices;
	}
	
	public static void print(int []numbers) {
		System.out.print("[");
		for(int i=0;i<numbers.length;i++) {
			if( i == numbers.length-1)
				System.out.print(numbers[i]+"]");
			else
				System.out.print(numbers[i]+",");
		}
		System.out.println();
	}
	
	//hashmap的搜索速度是O(1)  而且能保证result[0]是小的那个数
	public static int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				result[0] = map.get(target - numbers[i]) + 1;
				result[1] = i + 1;
				break;
			} else {
				map.put(numbers[i], i);
			}
		}
		return result;
	}
	public static int[] twoSumII(int[] numbers, int target) {
		int[] result = new int[2];
		//record
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<numbers.length;i++) {
			map.put(i,numbers[i]);  //保证key值不重复
		}
		Arrays.sort(numbers);
		
		//search
		int i=0 ,j=numbers.length-1;
		while( i < j) {
			int sum = numbers[i] + numbers[j];
			if( sum < target) {
				i++;
			} else if( sum > target) {
				j--;
			} else {
				break;
			}
		}
		
		//position
		//TODO problem
		int pos1=0 ,pos2=0;
		boolean flag = false;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if( numbers[i] != numbers[j]) {
				if( numbers[i] == entry.getValue()) {
					pos1 = entry.getKey() +1;
				} 
				if( numbers[j] == entry.getValue() ) {
					pos2 = entry.getKey() +1;
				}
			} else {
				//两个数一样的时候  特别注意
				///
				///
				///
				if( numbers[i] == entry.getValue() && flag == false) {
					pos1 = entry.getKey() +1;
					flag = true;
				} 
				
				if( numbers[j] == entry.getValue()  && (pos1 != entry.getKey() +1 && flag)) {
					pos2 = entry.getKey() +1;
				}
				
			}
		}
		result[0] = pos1 < pos2 ? pos1 : pos2;
		result[1] = pos1 > pos2 ? pos1 : pos2;
		
		return result;
	}
	public static void main(String[] args) {
		int numbers[] = {0,4,0};
		System.out.print("original array:");
		print(numbers);
		print(twoSum(numbers,0));
		print(twoSumII(numbers,0));
		
		
		 
		
	}
}
