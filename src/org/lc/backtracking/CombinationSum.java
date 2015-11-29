package org.lc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a set of candidate numbers (C) and a target number (T),
 find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] */
public class CombinationSum {
	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
		 List<List<Integer>> res = new ArrayList<List<Integer>>();
		 
		 if(candidates.length == 0)
			 return res;
		 
		 Arrays.sort(candidates);
		 dfs(0,candidates,target,new ArrayList<Integer>(),res);
		 return res;
	 }

	private void dfs(int start, int[] candidates, int target,
			ArrayList<Integer> list, List<List<Integer>> res) {
		if( target == 0 ) {
			res.add(new ArrayList<Integer>(list));
			return ;
		}
		if(target < 0)
			return;
		
		for (int i = start; i < candidates.length; i++) {
			if(i>start && candidates[i]==candidates[i-1] )
				continue;
			
			list.add(candidates[i]);
			dfs(i,candidates,target-candidates[i],list,res);
			list.remove(list.size()-1);
		}
	}
	
	public static void main(String[] args) {
		int candidates[] = {2,3,6,7};
		int target = 7;
		CombinationSum ins = new CombinationSum();
		System.out.println(ins.combinationSum(candidates, target));
	}
	
}
