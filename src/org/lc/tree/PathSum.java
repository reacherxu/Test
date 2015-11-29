package org.lc.tree;

import org.lc.util.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
 * such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * @author Reacher
 *
 */
public class PathSum {
	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root == null)
			return false;
		
		if(root.left == null && root.right == null && root.val == sum)
			return true;
		else
			return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
	}
	public static void main(String[] args) {
		int a[] = {5,4,8,11,0,13,4,7,2,0,0,0,1};
		TreeNode root = TreeNode.plant(a);
		System.out.println(hasPathSum(root,22));
	}
}
