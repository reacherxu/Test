package org.lc.tree;

import org.lc.util.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree 
in which the depth of the two subtrees of every node never differ by more than 1.
 * @author Reacher
 *
 */
public class BalancedBinaryTree {
	public static boolean isBalanced(TreeNode root) {
		if(root == null)
			return true;
		
		int left = getDepth(root.left);
		int right = getDepth(root.right);
		
		if( Math.abs(left - right) > 1)
			return false;
		else
			return isBalanced(root.left) && isBalanced(root.right);
	}
	
	private static int getDepth(TreeNode node) {
		if( node == null )
			return 0;
		
		int left = getDepth(node.left);
		int right = getDepth(node.right);
		return left > right ? left+1 : right+1;
	}

	
	public static void main(String[] args) {
//		int a[] = {10,5,15};
    	int b[] = {10,5,0,0,15};
//		TreeNode rootA = TreeNode.plant(a);
		TreeNode rootB = TreeNode.plant(b);
		
		System.out.println(isBalanced(rootB));
	}
}
