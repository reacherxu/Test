package org.lc.tree;

import org.lc.util.TreeLinkNode;

/**
 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. 
If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree
 (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 * @author Reacher
 *
 */
public class PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
		dfs(root);
	}

	private void dfs(TreeLinkNode node) {
		if(node == null)
			return;
		
		if(node.left != null)
			node.left.next = node.right;
		if(node.right!=null && node.next!=null)
			node.right.next = node.next.left;
		
		dfs(node.left);
		dfs(node.right);
	}

	public static void main(String[] args) {
//		int a[] = {1,2,3,4,5,6,7};
//		TreeLinkNode root = TreeLinkNode.plant(a);
	}
}
