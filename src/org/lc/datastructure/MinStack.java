package org.lc.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 * @author Reacher
 *
 */
public class MinStack {
	List<Integer> stack = new ArrayList<Integer>();
	List<Integer> minStack = new ArrayList<Integer>();
	
	public void push(int x) {
		stack.add(x);
		if( minStack.isEmpty() || x <= minStack.get(minStack.size()-1))
			minStack.add(x);
	}

	public void pop() {
		int val = stack.remove(stack.size()-1);
		if( val == minStack.get(minStack.size()-1))
			minStack.remove(new Integer(val));
	}

	public int top() {
		if( stack.isEmpty())
			return 0;
		return stack.get(stack.size()-1);
	}

	public int getMin() {
		if(!minStack.isEmpty())
			return minStack.get(minStack.size()-1);
		return 0;
	}
	
	public void print() {
		System.out.println(this.stack); 
	}
	
	public static void main(String[] args) {
		MinStack ms = new MinStack();
		ms.push(-2);
		ms.push(0);
		ms.push(-1);
		
		System.out.println(ms.getMin());
		ms.top();
		ms.pop();
		ms.getMin();
	}
}
