package org.lc.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		dfs(num,new ArrayList<Integer>(),res);
		return res;
	}
	private void dfs(int[] num, ArrayList<Integer> list,
			List<List<Integer>> res) {
		if(list.size() == num.length) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		
		for (int i = 0; i < num.length; i++) {
			if( !list.contains(num[i]) )
				list.add(num[i]);
			else
				continue;
			dfs(num, list, res);
			list.remove(list.get(list.size()-1));
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Permutation ins = new Permutation();
		int num[] = {1,2,3,4};
		System.out.println(ins.permute(num));

	}

}
