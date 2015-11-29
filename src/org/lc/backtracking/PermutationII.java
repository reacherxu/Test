package org.lc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a collection of numbers that might contain duplicates,
 *  return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].*/
public class PermutationII {
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		Arrays.sort(num);
		dfs(num,new ArrayList<Integer>(),new ArrayList<Integer>(),res);
		return res;
	}
	
	private void dfs(int[] num, ArrayList<Integer> list,
			ArrayList<Integer> used, List<List<Integer>> res) {
		if(used.size() == num.length) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		
		for (int i = 0; i < num.length; i++) {
			if( used.contains(i) || (i>0 && num[i]==num[i-1] && !used.contains(i-1)))
				continue;
			list.add(num[i]);
			used.add(i);
			dfs(num, list, used, res);
			list.remove(list.size()-1);
			used.remove(used.size()-1);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PermutationII ins = new PermutationII();
		int num[] = {};
		System.out.println(ins.permuteUnique(num));
	}

}
