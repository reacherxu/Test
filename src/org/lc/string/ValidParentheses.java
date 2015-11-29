package org.lc.string;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 *  determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid 
but "(]" and "([)]" are not.
 * @author Reacher
 *
 */
public class ValidParentheses {
	public boolean isValid(String s) {
		if(s == null)
			return true;
		if(s.length() % 2 == 1)
			return false;
		
		Stack<String> stack = new Stack<String>();
		stack.add(s.substring(0,1));
		for (int i = 1; i < s.length(); i++) {
			String next = s.substring(i,i+1);
			if(stack.size() > 0) {
				String cur = stack.peek();
				if( !pair(cur,next) ) {
					stack.push(next);
				} else {
					stack.pop();
				}
			} else {
				stack.push(next);
			}
		}
		
		if(stack.size() == 0)
			return true;
		else 
			return false;
	}
	//	'(', ')', '{', '}', '[' and ']',
	private boolean pair(String top, String next) {
		if(top.equals("(") && next.equals(")"))
			return true;
		if(top.equals("{") && next.equals("}"))
			return true;
		if(top.equals("[") && next.equals("]"))
			return true;
		return false;
	}

	public static void main(String[] args) {
		ValidParentheses ins = new ValidParentheses();
		System.out.println(ins.isValid("([])"));
	}
}
