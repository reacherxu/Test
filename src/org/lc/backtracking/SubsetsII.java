package org.lc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 * @author Reacher
 *
 */
public class SubsetsII {
	public static List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		
		if( num.length == 0)
			return res;
		
		Arrays.sort(num);
		
		for( int i=0; i<num.length; i++) { //get every element in num
			int size = res.size();

			for(int j=0; j<size; j++) { //obtain every subset in result
				ArrayList<Integer> tmp = new ArrayList<Integer>(res.get(j));

				tmp.add(num[i]);
				
				addElement(res,tmp);
			}
		}
		
		return res;
	}

	private static void addElement(List<List<Integer>> res,
			ArrayList<Integer> tmp) {
		for(int i=0;i<res.size();i++) {
			if(res.contains(tmp)) 
				return;
		}
		res.add(tmp);
	}

	public static List<List<Integer>> subsetsWithDupII(int[] num) {
		List<List<Integer>> res = new  ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		
		if( num.length == 0 )
			return res;
		Arrays.sort(num);
		
		
		dfs(0,num,new ArrayList<Integer>(),res);
		return res;
	}
	private static void dfs(int start, int[] s, ArrayList<Integer> list,
			List<List<Integer>> res) {
		for(int i=start;i<s.length;i++) {
			if( i > start && s[i] == s[i-1] )
				continue;
			
			list.add(s[i]);
			System.out.println(list);
			res.add(new ArrayList<Integer>(list));
			dfs(i+1,s,list,res);
			list.remove(list.size()-1);
		}
	}

	public static void main(String[] args) {
		int S[] = {1,2,2};
		System.out.println(subsetsWithDupII(S));
	}
}
