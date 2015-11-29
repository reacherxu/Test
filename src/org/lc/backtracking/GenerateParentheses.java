package org.lc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses,
 *  write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
"((()))", "(()())", "(())()", "()(())", "()()()"
 * @author Reacher
 *
 */
public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		StringBuilder parenthese = new StringBuilder("");
		dfs(n,n,parenthese,res);
		return res;
	}

	private void dfs(int left, int right, StringBuilder parenthese, List<String> res) {
		if( left > right)
			return;
		if( left == 0 && right == 0) {
			res.add(new String(parenthese));
			return;
		}
		
		if( left > 0) {
			parenthese.append("(");
			dfs(left-1,right,parenthese,res);
			parenthese.deleteCharAt(parenthese.length()-1);
		}
		if( right > 0) {
			parenthese.append(")");
			dfs(left,right-1,parenthese,res);
			parenthese.deleteCharAt(parenthese.length()-1);
		}
	}

	public static void main(String[] args) {
		GenerateParentheses ins = new GenerateParentheses();
		System.out.println(ins.generateParenthesis(3));
	}
}
