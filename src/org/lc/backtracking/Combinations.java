package org.lc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, 
 * return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 * @author Reacher
 *
 */
public class Combinations {
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		List<List<Integer>> temp = new ArrayList<List<Integer>>();
		temp.add(new ArrayList<Integer>());
		for (int i = 1; i <= n; i++) {
			int size = temp.size();
			for (int j = 0; j < size; j++) {
				List<Integer> list = new ArrayList<Integer>(temp.get(j));
				list.add(i);
				temp.add(list);
				if( list.size() == k)
					res.add(list);
			}
		}
		return res;
	}

	public static List<List<Integer>> combineII(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		dfsII(n,k,1,new ArrayList<Integer>(),res);
		return res;
	}
	/*private static void dfs(int n, int k, int start, ArrayList<Integer> list,
			List<List<Integer>> res) {
		if( list.size() == k ) {
			res.add(new ArrayList<Integer>(list));
			return ;
		}
		
		for (int j = start; j <= n; j++) {
			list.add(j);
			System.out.println(list);
			dfs(n,k,j+1,list,res);
			list.remove(list.size()-1);
		}
			
	}*/
	
	private static void dfsII(int n, int k, int start, List<Integer> list,
			List<List<Integer>> res) {
//		if( list.size() == k) {
//			res.add(new ArrayList<Integer>(list));
//			return ;
//		}
		
		for (int i = start; i <= n; i++) {
			list.add(i);
//			res.add(new ArrayList<Integer>(list));
			System.out.println(list);
			dfsII(n,k,i+1,list,res);
			list.remove(list.size()-1);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> res = combineII(4,3);
		System.out.println("result:"+res);
	}
}
