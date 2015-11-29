package org.lc.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, 
 * add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
 * @author Reacher
 *
 */
public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> dict) {
		
		List<String> res = new ArrayList<String>();
		if(s == null)
			return res;
		dfs(s,dict,0,"",res);
		return res;
	}

	private void dfs(String s, Set<String> dict, int start, String tmp,
			List<String> res) {
		if( start == s.length() ) {
			res.add(new String(tmp.trim()));
			return;
		}
		
			
		for (int i = start; i < s.length(); i++) {
			tmp += s.charAt(i);
			if( dict.contains(s.substring(start,i+1)) )  //不需要回溯,一路走到底
				dfs(s,dict,i+1,tmp+" ",res);
		}
			
	}

	public static void main(String[] args) {
		String s = null;
		HashSet<String>	dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		WordBreakII ins = new WordBreakII();
		System.out.println(ins.wordBreak(s, dict));
	}
}
