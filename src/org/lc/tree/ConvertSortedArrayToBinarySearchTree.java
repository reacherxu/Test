package org.lc.tree;

import org.lc.util.TreeNode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * @author Reacher
 *
 */
public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		return binaryBuildTree(num,0,num.length-1);
	}

	private TreeNode binaryBuildTree(int[] num, int start, int end) {
		if(start > end)
			return null;
		
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = binaryBuildTree(num, start, mid-1);
		root.right = binaryBuildTree(num, mid+1, end);
		return root;
	}
}
