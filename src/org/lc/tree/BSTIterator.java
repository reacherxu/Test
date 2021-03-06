package org.lc.tree;

import java.util.Stack;

import org.lc.util.TreeNode;

/**
 * Implement an iterator over a binary search tree (BST).
 *  Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.
Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, 
where h is the height of the tree.
 * @author Reacher
 *
 */

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
public class BSTIterator {
	private Stack<TreeNode> stack = new Stack<TreeNode>();
	public BSTIterator(TreeNode root) {
		pushLeft(root);
	}

	private void pushLeft(TreeNode node) {
		while( node != null ) {
			stack.push(node);
			node = node.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = stack.pop();
		pushLeft(node.right);
		return node.val;
	}

	public static void main(String[] args) {
		TreeNode root = null;
		
		BSTIterator i = new BSTIterator(root);
		while (i.hasNext()) 
			System.out.println(i.next()); 
	}
}
