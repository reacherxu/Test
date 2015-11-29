package org.lc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a collection of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] */
public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if(num.length == 0)
			return res;

		Arrays.sort(num);
		dfs(0,num,target,new ArrayList<Integer>(),res);
		return res;
	}
	private void dfs(int start, int[] num, int target,
			ArrayList<Integer> list, List<List<Integer>> res) {
		if( target == 0) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		if( target < 0) 
			return ;
		
		for (int j = start; j < num.length; j++) {
			if( j>start && num[j]==num[j-1]) //j>start很纠结
				continue;
			list.add(num[j]);
			dfs(j+1,num,target-num[j],list,res);
			list.remove(list.size()-1);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CombinationSumII ins = new CombinationSumII();
		int num[] = {10,1,2,7,6,1,5};
		int target = 8;
		System.out.println(ins.combinationSum2(num, target));
	}

}
