package org.lc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
 * @author Reacher
 *
 */
public class PermutationSequence {
	public String getPermutation(int n, int k) {
		if(k < 0 )
			return null;
		
		List<String> res = new ArrayList<String>();
		
		dfs(n,k,new String(""),res);
		return res.get(k-1);
	}
	
	private void dfs(int n,int k, String str, List<String> res) {
		if( str.length() == n) {
			res.add(new String(str));
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if( str.contains(String.valueOf(i)) )
				continue;
			str += i;
			if(res.size() == k)
				break;
			dfs(n,k,  str, res);
			str = str.substring(0,str.length()-1);
			
		}
	}
	public static void main(String[] args) {
		PermutationSequence ins = new PermutationSequence();
		System.out.println(ins.getPermutation(3, 5));
	}
}
