package org.lc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.lc.util.Util;
/**
 * Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 * @author Reacher
 *
 */
public class Subsets {
	public static List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> res = new  ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		
		if( S.length == 0 )
			return res;
		
		Arrays.sort(S);
		for(int i=0; i<S.length; i++) {//every time add one element
			int size = res.size();
			for(int j=0; j<size; j++) { //obtain all the subsets in result
				ArrayList<Integer> tmp = new ArrayList<Integer>(res.get(j));
				tmp.add(S[i]);
				res.add(tmp);
			}
		}
		
		return res;
	}

	
	public static List<List<Integer>> subsetsII(int[] S) {
		List<List<Integer>> res = new  ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		
		if( S.length == 0 )
			return res;
		Arrays.sort(S);
		
		
		dfs(0,S,new ArrayList<Integer>(),res);
		return res;
	}
	private static void dfs(int start, int[] s, ArrayList<Integer> list,
			List<List<Integer>> res) {
		for(int i=start;i<s.length;i++) {
			list.add(s[i]);
			System.out.println(list);
			res.add(new ArrayList<Integer>(list));
			dfs(i+1,s,list,res);
			list.remove(list.size()-1);
		}
	}


	public static void main(String[] args) {
		int S[] = {1,2,3};
		Util.print(subsetsII(S));
	}
}
